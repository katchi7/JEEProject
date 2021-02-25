package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

import jakarta.annotation.Resource;

import com.ensias.beans.Module;
import static org.mockito.Mockito.verify;

class ModuleDaoTest {
	
	public static String Table = "element";
	public static String ID =  "elm_id";
	public static String name =  "elm_name" ;
	public static String module_elm =  "elm_module"; 
	public static String description =  "elm_description"; 
	public static String annee = "elm_annee"; 
	public static String semester =  "elm_semester"; 
	public static String exam = "date_exam";
	public static String Association = "inscrit";
	public static String Association_elm_id = "id_elm";
	public static String Association_user_id = "id_user";

	@Resource(mappedName = "/Daofactory")
	private static DaoFactory factory;  
	
	@Mock
    private Connection conn; 
	
	@Mock
    private PreparedStatement stm;  
	
	@Mock
    private ResultSet dResult; 
	@Mock
    private ResultSet set; 
	
	@Test
	void testfindAllModules() throws SQLException, ClassNotFoundException, IOException {

		factory=factory.getInstance();
		ModuleDao m1=new ModuleDao(factory);
		ArrayList<Module> modules = new ArrayList<Module>();		
		Connection conn = Mockito.mock(Connection.class);
		PreparedStatement stm= Mockito.mock(PreparedStatement.class);
		conn = factory.getConnection();
		stm = conn.prepareStatement("SELECT * FROM element;");
		set=stm.executeQuery();
		while(set.next()) {
			Module m = new Module();
			m.setElm_id(set.getInt(this.ID));
			m.setElm_name( URLDecoder.decode(new String(set.getString(this.name).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
			m.setElm_module( URLDecoder.decode(new String(set.getString(this.module_elm).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8") );
			m.setElm_description(URLDecoder.decode(new String(set.getString(this.description).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8")  );
			m.setElm_annee(set.getString(this.annee));
			m.setElm_semester(set.getString(this.semester));
			modules.add(m);
		}
		
		//when(conn.prepareStatement("SELECT * FROM element;")).thenReturn(stm1);
        when(stm.executeQuery()).thenReturn(dResult);
       
        ArrayList<Module> result = m1.findAllModules();
        assertSame(modules.size(),result.size());
	}
	
    
@Test
void testFindModuleById() {
	ModuleDao module= Mockito.mock(ModuleDao.class);
	Module sampleModule = new Module();
	sampleModule.setElm_id(0);
    when(module.findModuleById(0)).thenReturn(sampleModule);
    assertEquals(0,module.findModuleById(0).getElm_id());
}

}
