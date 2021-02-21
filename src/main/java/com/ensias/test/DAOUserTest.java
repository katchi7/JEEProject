package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

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

@RunWith(MockitoJUnitRunner.class)
class DAOUserTest {
	
	private static final String REGISTRATION_EMAIL = "anfar99.asmaa@gmail.com";
	private static final String REGISTRATION_EMAIL2 = "jhon.smith@gmail.com";
    private static final String REGISTRATION_FIRST_NAME = "John";
    private static final String REGISTRATION_LAST_NAME = "Smith";
    private static final String REGISTRATION_PASSWORD ="12345";
    private static final String REGISTRATION_ADMIN ="0";
    private static final String REGISTRATION_NUM ="0629784512";
    private static final String REGISTRATION_NV ="1A";
    private static final String REGISTRATION_FILIERE = "GL";

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Mock
    private DAOUser daouser; 
	
	@Test
	void testCreate() {
		
		User sampleUser = new User();
		User user1 =new User();
		
		List<User> userMap = new ArrayList<>();
		DAOUser dao = Mockito.mock(DAOUser.class);
		when(dao.Create(sampleUser)).thenAnswer(i -> {
		    User user2 = i.getArgument(0);
		    userMap.add(user2.getId(), user1);
		    return null;
		});
		when(dao.findUser(user1.getEmail())).thenAnswer(i -> {
		    int id = i.getArgument(0);
		    return userMap.get(id);
		});

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
