package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.tools.ant.types.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ensias.Forms.InsricptionForm;
//import org.mockito.junit.jupiter.MockitoExtension;
import com.ensias.beans.User;
import com.ensias.dao.DAOUser;
import com.ensias.dao.DaoFactory;

import jakarta.annotation.Resource;

@RunWith(MockitoJUnitRunner.class)
class DAOUserTest {
	
	private static final String REGISTRATION_EMAIL = "anfar99.asmaa@gmail.com";
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Mock
    private DAOUser daouser; 
	
	@Resource(mappedName = "/Daofactory")

	   private static DaoFactory factory;
	
	@Test
	void testCreate() {

        factory=factory.getInstance();
		DAOUser userdao=new DAOUser(factory);
		User user= new User();
		user.setAdministrator(false);
		user.setEmail("test287@gmail.com");
		user.setFiliere("GL");
		user.setFname("Douaa");
		user.setLname("ANFAR");
		//user.setId(55);
		user.setNiveau("1A");
		user.setNum("0626597845");
		user.setPassword("testpassword");
		//user.setFull_filiere("Génie Logiciel");
		userdao.Create(user);
		Integer id = user.getId();
		assertTrue(id>0);
		System.out.println("The user:"+user.getFname()+" "+"of id : "+id+" "+"and email : "+user.getEmail()+" is created succefully!");
	}
		
	@Test
	void testFindUser() {
		
		DAOUser user= Mockito.mock(DAOUser.class);
		User sampleUser = new User();
		sampleUser.setEmail("anfar99.asmaa@gmail.com");
        when(user.findUser(REGISTRATION_EMAIL)).thenReturn(sampleUser);
        assertEquals("anfar99.asmaa@gmail.com",user.findUser(REGISTRATION_EMAIL).getEmail());
	}	
}
