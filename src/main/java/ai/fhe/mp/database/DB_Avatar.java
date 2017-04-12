package ai.fhe.mp.database;

import ai.fhe.mp.model.Avatar;
import ai.fhe.mp.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by rofel on 12.04.2017.
 */
public class DB_Avatar {

    /**
     * internal db-function
     * get a user by userid
     * @param _ID userid
     * @return Response with user if available
     */
    public static Response getAvatar(Integer _ID)
    {
        System.out.println("getAvatar Func int");
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction  = session.beginTransaction();
        List avatarList = session.createQuery( "from Avatar A where A.userId is "+ _ID ).list();
        transaction.commit();
        Avatar avatar = (Avatar) avatarList.get(0);
        return Response.ok().entity(avatar).build();
    }

}
