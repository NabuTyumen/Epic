package epic.sample;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
	  private static final SessionFactory sessionFactory;
	  private static ServiceRegistry serviceRegistry;
	    static {
	    	 try{
    		    		 
	    		   Configuration configuration = new Configuration();
	    		    configuration.configure();
	    		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	    		            configuration.getProperties()).build();
	    		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	    		 
	          }catch (Throwable ex) { 
	             System.err.println("Failed to create sessionFactory object." + ex);
	             throw new ExceptionInInitializerError(ex); 
	          }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
