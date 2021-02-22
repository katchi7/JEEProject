package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ensias.config.InitDaoFactory;
import com.ensias.dao.DAOConfigurationException;
import com.ensias.dao.DAOUser;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;
import com.mysql.cj.Query;
import com.ensias.beans.Module;
import static org.mockito.Mockito.verify;



class ModuleDaoTest {
	
	private static final String PROPERTIES_FILE = "/mysql.properties";
	private static final String PROPERTY_URL ="url";
	private static final String PROPERTY_DRIVER ="driver";
	private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD    = "password";
	 
	 
     
    /* ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
     InputStream fichierProperties = classLoader.getResourceAsStream( PROPERTIES_FILE );
     properties.load( fichierProperties );
     String url1 = properties.getProperty( PROPERTY_URL );
     String nomUtilisateur = properties.getProperty( PROPERTY_USERNAME );
     String motDePasse = properties.getProperty( PROPERTY_PASSWORD );*/
	

	 Properties properties = new Properties();
       String url;
       String driver;
       String nomUtilisateur;
       String motDePasse;

       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       InputStream fichierProperties = classLoader.getResourceAsStream( PROPERTIES_FILE );


   
          /* properties.load( fichierProperties );
           url = properties.getProperty( PROPERTY_URL );
           driver = properties.getProperty( PROPERTY_DRIVER );
           nomUtilisateur = properties.getProperty( PROPERTY_USERNAME );
           motDePasse = properties.getProperty( PROPERTY_PASSWORD );
      

      /* try {
           Class.forName( driver );
       } catch ( ClassNotFoundException e ) {
           throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
       }*/
       

      instance = new DaoFactory( url, nomUtilisateur, motDePasse );

	@Test
	void testFindModuleById() {
		ModuleDao module= Mockito.mock(ModuleDao.class);
		Module sampleModule = new Module();
		sampleModule.setElm_id(0);
        when(module.findModuleById(0)).thenReturn(sampleModule);
        assertEquals(0,module.findModuleById(0).getElm_id());
	}
	
	@Test
	void testfindAllModules() throws SQLException, ClassNotFoundException {
		Connection conn = DriverManager.getConnection(url,nomUtilisateur,motDePasse);
		//Connection conn = null;
		//conn =  factory.getConnection(); 
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM element;");
		
		ModuleDao module= Mockito.mock(ModuleDao.class);
		//Query query = Mockito.mock(Query.class);
        when(conn.prepareStatement("SELECT * FROM element;")).thenReturn(stm);
        // stub the query returned above to return a meaningful result when somebody
        // asks for the result list
        ResultSet dResult = (ResultSet) new LinkedList<Module>();
        when(stm.executeQuery()).thenReturn(dResult);

        // let's call findAll() and see what it does
        List<Module> result = module.findAllModules();

        // did it request the named query?
        verify(conn).prepareStatement("SELECT * FROM element;");
        // did it ask for the result list of the named query?
        verify(stm).executeQuery();
        // did it return the result list of the named query?
        assertSame(dResult, result);
	}
}
