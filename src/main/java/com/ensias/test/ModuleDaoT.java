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
	 
	@Inject
	private ModuleDao module;
	 
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testFindeAllModules() throws SQLException, UnsupportedEncodingException {
		factory=factory.getInstance();
		ModuleDao m=new ModuleDao(factory);
		ArrayList<Module> modules = new ArrayList<>();
		modules=m.findAllModules();
		
		assertTrue(!modules.isEmpty());
        assertEquals(13, modules.size());
		//Assert.assertTrue(true);
	}
	
	@Test
    public void testAddModule(){
		
        
        factory=factory.getInstance();
		ModuleDao mdao=new ModuleDao(factory);
		
		ArrayList<Module> modules = new ArrayList<>();
		modules=mdao.findAllModules();
        Module m = new Module();
        m.setElm_id(22);
        m.setElm_name("test");
        m.setElm_description("......");
        m.setElm_annee("2020");
        m.setElm_semester("S3");
        m.setElm_module("trstt");

		ArrayList<String> filieres= new ArrayList<String>();
		filieres.add("gl");
		filieres.add("bi");
		mdao.creerModules(m,filieres );
		
		ArrayList<Module> modulesAdd = new ArrayList<>();
		modulesAdd=mdao.findAllModules();
		assertEquals(modulesAdd.size(), modules.size()+1);
		
		
    }
	 

}
