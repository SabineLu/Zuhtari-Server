package ai.fhe.mp.marshalling;

/**
 * object to check name and password for login without giving the whole userobject
 */
public class Login
{
    //setter and getter
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    String name;
    String password;
}
