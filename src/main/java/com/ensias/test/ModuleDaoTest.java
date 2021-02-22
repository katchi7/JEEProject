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
	
	private static final String PROPERTIES_FILE = "/projectJee/resources/mysql.properties";
	private static final String PROPERTY_URL ="url";
	private static final String PROPERTY_DRIVER ="driver";
	private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD    = "password";
	    
	@Test
	void testFindModuleById() {
		ModuleDao module= Mockito.mock(ModuleDao.class);
		Module sampleModule = new Module();
		sampleModule.setElm_id(0);
        when(module.findModuleById(0)).thenReturn(sampleModule);
        assertEquals(0,module.findModuleById(0).getElm_id());
	}
	
	@Mock
    private Connection conn; 
	
	@Mock
    private PreparedStatement stm; 
	
	@Mock
    private ResultSet dResult; 
	
	@Test
	void testfindAllModules() throws SQLException, ClassNotFoundException, IOException {

    //DaoFactory instance = new DaoFactory( url, nomUtilisateur, motDePasse );
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection conn = Mockito.mock(Connection.class);
		//PreparedStatement stm= Mockito.mock(PreparedStatement.class);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ensias_doc","root","bac2017bac.");
		stm = conn.prepareStatement("SELECT * FROM element;");
		
		ModuleDao module= Mockito.mock(ModuleDao.class);
       	
        when(stm.executeQuery()).thenReturn(dResult);
       
        ArrayList<Module> result = module.findAllModules();
        result= null;
        
        //verify(conn).prepareStatement("SELECT * FROM element;");
       
        //verify(stm).executeQuery();
       
        assertSame(dResult, result);
	}
}
