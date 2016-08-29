package ai.fhe.mp.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.ws.rs.core.Response;

/**
 * helper-class for Hibernate
 * creates a SessionFactory-object which in turn can open up new Session's
 */
public class HibernateUtil
{

    private static SessionFactory m_SessionFactory;


    /**
     * internal db-function
     * create a session factory
     * use the same the whole time
     * create a new if not exist
     * @return sessionFactory
     */
    public static SessionFactory getSessionFactory()
    {
        if (m_SessionFactory == null)
        {
            m_SessionFactory = buildSessionFactory();
        }
        return m_SessionFactory;
    }

    /**
     * outsourced function to add an object to the database
     * @param _obj Object of database-entity (one of the model package)
     * @return Response with 200 if succesful, else 304 not modified
     */
    public static Response addToDB(Object _obj)
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction currentTransaction = null;
        try
        {
            currentTransaction = session.beginTransaction();
            session.save(_obj);
            currentTransaction.commit();
        }
        catch (HibernateException e)
        {
            //TransactionStatus transactionStatus = currentTransaction.getStatus();
            if (currentTransaction!=null) currentTransaction.rollback();
            e.printStackTrace();
            return Response.notModified().build();
        }
        finally
        {
            session.close();
        }

        return Response.ok().build();
    }


    public static Response updateOnDB(Object _obj)
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction currentTransaction = null;
        try
        {
            currentTransaction = session.beginTransaction();
            session.update(_obj);
            currentTransaction.commit();
        }
        catch (HibernateException e)
        {
            //TransactionStatus transactionStatus = currentTransaction.getStatus();
            if (currentTransaction!=null) currentTransaction.rollback();
            e.printStackTrace();
            return Response.notModified().build();
        }
        finally
        {
            session.close();
        }

        return Response.ok().build();
    }


    /**
     * create a new session factory at the beginning
     * map the config from hibernate.cfg.xml
     * @return sessionFactory with correct config
     */
    private static SessionFactory buildSessionFactory()
    {
        try
        {
            // Create session factory from cfg.xml
            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml");

            ServiceRegistry serviceRegistry = null;

            serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();


            Metadata Meta = new MetadataSources(serviceRegistry)
                    .getMetadataBuilder()
                    .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                    .build();

            SessionFactory sessionFactory = Meta.getSessionFactoryBuilder()
                    .build();

            return sessionFactory;
        }
        catch (Throwable ex)
        {
            System.err.println("Initial session factory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
