package com.ensias.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import com.ensias.dao.DaoFactory;


public class InitDaoFactory implements ServletContextListener {

	private static final String ATT_DAO_FACTORY = "daofactory";
	private DaoFactory daoFactory;
	
    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.setProperty( "file.encoding", "UTF-8" );
         ServletContext servletContext = sce.getServletContext();
         
         this.daoFactory = DaoFactory.getInstance();
         System.out.print(daoFactory);
         servletContext.setAttribute(ATT_DAO_FACTORY, daoFactory);
         
    }
	
}
