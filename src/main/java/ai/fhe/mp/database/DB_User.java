package ai.fhe.mp.database;

import javax.ws.rs.core.Response;

import ai.fhe.mp.marshalling.Login;
import ai.fhe.mp.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

/**
 * Connection between User-Model and database
 */
public class DB_User
{


    /**
     * internal db-function
     * get a user by userid
     * @param _ID userid
     * @return Response with user if available
     */
    public static Response getUser(Integer _ID)
    {
        System.out.println("getUser Func int");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction  = session.beginTransaction();
        List userList = session.createQuery( "from User U where U.id is "+_ID ).list();
        transaction.commit();
        User user = (User) userList.get(0);
        Response response;
        if (user != null)
            response = Response.ok().entity(user).build();
        else
            response = Response.ok().type("No User Found.").build();

        return response;
    }

    /**
     * internal db-function
     * get a user by mail
     * @param _Mail userMail
     * @return User with user if available
     */
    public static User getUser(String _Mail)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction  = session.beginTransaction();
        List userList = session.createQuery( "from User U where U.email like '"+_Mail +"'").list();
        transaction.commit();

        User user = null;

        //check if the list consist of any user
        if (!userList.isEmpty())
        {
            user = (User) userList.get(0);
        }


        return user;
    }

    /**
     * internal db-function
     * get a user by mail
     * @param _Name userName
     * @return User with user if available
     */
    public static User getUserByName(String _Name)
    {
        System.out.println("getUserByName Func string");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction  = session.beginTransaction();
        List userList = session.createQuery( "from User U where U.name like '"+_Name +"'").list();
        transaction.commit();
        User user = null;

        //check if the list consist of any user
        if (!userList.isEmpty())
        {
            user = (User) userList.get(0);
        }
        return user;
    }




    /**
     * internal db-function
     * check of user password combination exist
     * @param _Login object with String username and String password
     * @return Response with user if available
     */
    public static Response doesUserWithEmailAndPasswordExist(Login _Login)
    {
        String query = "from User U where (U.email like '" + _Login.getName() + "' and U.password like '" +  _Login.getPassword() + "')";

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction  = session.beginTransaction();
        List userList = session.createQuery( query).list();

        User user = (User) userList.get(0);
        transaction.commit();

        //check if the list consist of any user
        if(userList.isEmpty())
        {
            //No user found
            return Response.noContent().entity(user).build();
        }
        else
        {
            //user was found
            user = (User) userList.get(0);
            return Response.ok().entity(user).build();
        }
    }


    /**
     * internal db-function
     * add a single user to the database
     * @param _User user object with name, password, email ...
     * @return response message 200 if ok, else 304
     */
    public static Response addUser(User _User)
    {
        _User.setId(null);

        // user with same name not allowed
        if(doesUserWithNameExist(_User.getName()) && doesUserWithEmailExist(_User.getEmail()))
        {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else
        {
            // save user
            Response response = HibernateUtil.addToDB(_User);
            return response;
        }
    }


     /**
     * updates a single user on database
     * @param _User user to be changed
     * @return Response 200 if ok, else not modified
     */
    public static Response updateUser(User _User)
    {
        Response oldUserResponse = getUser(_User.getId());
        User oldUser = (User) oldUserResponse.getEntity();
        if(oldUser.getName().equals(_User.getName()))
        {
            //update db data of user
            return HibernateUtil.updateOnDB(_User);
        }
        else
        {
            if(doesUserWithNameExist(_User.getName()))
            {
                // same name exist, not allowed
                return Response.status(Response.Status.CONFLICT).build();
            }
            else
            {
                return HibernateUtil.updateOnDB(_User);
            }
        }
    }


    /**
     * internal function to test adding a user without android client
     * @param _User user to be added
     * @return Response with 200 if seccessful
    */
    public static Response writeNewUser(User _User)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // create a java calendar instance
        Calendar calendar = Calendar.getInstance();

        // get a java date (java.util.Date) from the Calendar instance.
        // this java date will represent the current date, or "now".
        java.util.Date currentDate = calendar.getTime();

        // create a java.sql.Date from the java.util.Date
        java.sql.Date date = new java.sql.Date(currentDate.getTime());

        User user1 = new User(_User.getEmail(),_User.getName(),_User.getPassword(), date);
        session.save(user1);


        session.getTransaction().commit();
        session.close();

        return Response.ok().entity(user1).build();
    }


    /**
     * internal function
     * check if there is a user with given name, has to be unique
     * used for addUser
     * @param _Name String name of the user
     * @return true if exist, else false
     */
    private static boolean doesUserWithNameExist(String _Name)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction  = session.beginTransaction();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("name",_Name ));
        List userList = cr.list();
        transaction.commit();
        if(userList.isEmpty())
        {
            return false;
        }

        else
        {
            return true;
        }
    }

    /**
     * internal function
     * check if there is a user with given email, has to be unique
     * used for addUser
     * @param _Mail String email of the user
     * @return true if exist, else false
     */
    private static boolean doesUserWithEmailExist(String _Mail)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction  = session.beginTransaction();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("email",_Mail ));
        List userList = cr.list();
        transaction.commit();
        if(userList.isEmpty())
        {
            return false;
        }

        else
        {
            return true;
        }
    }

}
