package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Inject;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.ensias.beans.Module;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

import jakarta.annotation.Resource;

@RunWith(Arquillian.class)
//@RunAsClient
class ModuleDaoT {
	
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

	 @Deployment
	    public static JavaArchive createDeployment() {
	        return ShrinkWrap.create(JavaArchive.class)
	                .addClasses(Module.class, ModuleDao.class)
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	    }
	 
	 /*@Inject
	 private ModuleDao module;*/
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindeAllModules() throws SQLException, UnsupportedEncodingException {
		factory=factory.getInstance();
		Connection conn = null;
		ArrayList<Module> modules = new ArrayList<>();
	    conn = factory.getConnection();
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM element;");
		ResultSet set = stm.executeQuery();
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
		//ArrayList<Module> result =module.findAllModules();
		assertTrue(!modules.isEmpty());
		//System.out.println(String.format("Total of Cars %d", module.findAllModules().size()));

        assertEquals(3, modules.size());
		Assert.assertTrue(true);
	}
	 

}
