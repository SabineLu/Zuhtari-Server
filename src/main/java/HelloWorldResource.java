import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Test class
 * Created by Sabine Lueck on 19.07.16.
 */
@Path("/hello")
public class HelloWorldResource {
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String getGreeting()
    {
        System.out.println("Message");
        return "Server Example";
    }
}
