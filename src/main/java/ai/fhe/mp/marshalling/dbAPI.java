package ai.fhe.mp.marshalling;

import ai.fhe.mp.Controller.CreateImageController;
import ai.fhe.mp.database.DB_User;
import ai.fhe.mp.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Hashtable;
//TODO: check the response if responses are all set right when returning information to the client
//TODO: return only set right with info for the if name and email exist on register
/**
 * Created by Sabine Lueck on 19.07.16.
 */
@Path( "/db" )
public class dbAPI
{
    ///////////////////////////
    /////// User


    /**
     * testfunction
     * Get user by id
     * @param _ID user id
     * @return Response with 200 or 400
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path( "user/{id}" )
    public Response getUserById(@PathParam("id") Integer _ID)
    {
        return DB_User.getUser(_ID);
    }



    /**
     * add a user to the database
     * prove if name already exist
     * last tested
     * @statuscode 200 user added
     * @statuscode 204 user not added, database not modified
     * @statuscode 409 user email already exist
     * @statuscode 408 user name already exist
     *  user which should be added to database
     * @return Response with 200 if successful, else 204 or 409
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path( "user/addNewUser" )
    public Response addUser(Hashtable _User)
    {
        User user = new User();
        user.setName(_User.get("username").toString());
        user.setPassword(_User.get("password").toString());
        user.setEmail(_User.get("email").toString());
        Response returnResponse = null;

        if ( DB_User.getUser(user.getEmail())!= null)
        {
            returnResponse = Response.status(409).entity(user).build();
        }else if (DB_User.getUserByName(user.getName()) != null)
        {
            returnResponse = Response.status(408).entity(user).build();
        }
        else{
            DB_User.writeNewUser(user);
            returnResponse = Response.ok().entity(user).build();
        }

        return returnResponse;
    }

    /**
     * change values of user
     * prove if name already exist
     * last tested 08.02.16
     * @statuscode 200 user added
     * @statuscode 204 user not changed, database not modified
     * @statuscode 409 user already exist
     * @param _User user which should be changed on database
     * @return Response with 200 if successful, else 204 or 409
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path( "user" )
    public Response updateUser( User _User)
    {
        System.out.println("Name: " + _User.getName());
        return DB_User.updateUser(_User);
    }


    /**
     * check if user password combination exist
     * @statuscode 200 user exist and password is correct
     * @statuscode 204 no user with given password
     * @param _User contains String username  and String password
     * @return response with 200 and user or 204
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path( "user/namepassword" )
    public Response doesUserWithNameAndPasswordExist( Hashtable _User)
    {
        System.out.println("Bin in doesUserWithNameAndPasswordExist");
        Login login = new Login();
        login.setName(_User.get("username").toString());
        login.setPassword(_User.get("password").toString());
        return DB_User.doesUserWithEmailAndPasswordExist(login);
    }


    //TODO: remove test function

    /**
     * test function to see if server works
     * @return
     */
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Path( "userText" )
    public String getGreeting()
    {
        System.out.println("User Test");
        return "Neuer Server Test";
    }

    /**
     * send mail to user if new password was made and the given email exist in db
     * @param _Mail
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user/sendNewPWMailAndUpdateUser")
    public Response sendMail(Hashtable _Mail)
    {
        System.out.println("sendMail Func");
        String Mail = _Mail.get("mail").toString();//_stng.get("mail").toString();
        SendMailSSL mailSSL = new SendMailSSL();
        User user = null;
        user = DB_User.getUser(Mail);
        if (user != null)
        {
            String newPW = mailSSL.SendNewPasswordMail(Mail);
            System.out.println("Sending Mail");
            user.setPassword(newPW);
            System.out.println("Updated User DB Data");
            DB_User.updateUser(user);
            System.out.println(Response.ok().build());
            return Response.ok().entity(user).build();

        }else{
            System.out.println("Error");
            return Response.noContent().build();
        }

    }

    /**
     * save new password to user db
     * @param _User
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user/sendNewInputPWAndUpdateUser")
    public Response saveNewPassword(Hashtable _User)
    {
        System.out.println("sendMail Func");
        String Mail = _User.get("mail").toString();

        User user = null;
        user = DB_User.getUser(Mail);
        if (user != null)
        {
            String newPW = _User.get("pw").toString();
            user.setPassword(newPW);
            System.out.println("Updated User DB Data");
            DB_User.updateUser(user);
            return Response.ok().entity(user).build();

        }else{
            System.out.println("Error");
            return Response.noContent().build();
        }

    }

    //TODO: change functionName and call function to make dyn pictures
    /**
     * Test Image Creation on Server!
     * @return
     */
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Path( "userImageTest" )
    public String testImageCreation()
    {
        System.out.println("Image Creation Test");
        CreateImageController ImageController = new CreateImageController();
        try {
            try {
                ImageController.MakePicture();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Image was created";
    }

    //TODO: change name and how function work to give dyn. pictures back
    /**
     * Test Image Show on Server!
     * @return
     */
    @GET
    @Produces( "image/png")
    @Path( "userImageShowTest" )
    public Response testImageShow()
    {
        //Get Path of the persistant part of the Server
        String path =System.getenv("OPENSHIFT_DATA_DIR"); // base path of the images
        File repositoryFile = new File(path+"combinedTest.png");
        return returnFile(repositoryFile);
    }

    public static Response returnFile(File file) {
        if (!file.exists()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        try {
            return Response.ok(new FileInputStream(file)).build();
        } catch (FileNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
