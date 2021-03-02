package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

import org.jboss.arquillian.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ensias.beans.Module;
import com.ensias.beans.User;
import com.ensias.dao.DAOUser;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

import jakarta.annotation.Resource;

class DAOUserT {
	
	@Resource(mappedName = "/Daofactory")

	   private static DaoFactory factory;

	 @Deployment
	    public static JavaArchive createDeployment() {
	        return ShrinkWrap.create(JavaArchive.class)
	                .addClasses(User.class, DAOUser.class)
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	    }

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCreate() {

        factory=factory.getInstance();
		DAOUser userdao=new DAOUser(factory);
		User user= new User();
		user.setAdministrator(false);
		user.setEmail("test0@gmail.com");
		user.setFiliere("GL");
		user.setFname("Douaa");
		user.setLname("ANFAR");
		//user.setId(55);
		user.setNiveau("1A");
		user.setNum("0626597845");
		user.setPassword("testpassword");
		//user.setFull_filiere("G�nie Logiciel");
		boolean b = userdao.Create(user);
		assertEquals(true,b);
		
	}

	@Test
	void testFindUser() {
		
		factory=factory.getInstance();
		DAOUser userdao=new DAOUser(factory);
		User user = userdao.findUser("anfar99.asmaa@gmail.com");
		int idd=user.getId();
		assertEquals(1,idd);
		
		
	}

}