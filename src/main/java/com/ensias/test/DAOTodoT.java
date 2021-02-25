package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.jboss.arquillian.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ensias.beans.Todo;
import com.ensias.beans.User;
import com.ensias.dao.DAOTodo;
import com.ensias.dao.DAOUser;
import com.ensias.dao.DaoFactory;

import jakarta.annotation.Resource;

class DAOTodoT {
	
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
	void testGetTodoByUser() {
		factory=factory.getInstance();
		DAOTodo tododao=new DAOTodo(factory);
		ArrayList<Todo> todos = tododao.getTodoByUser(2);
		ArrayList<Todo> todoList = new ArrayList<>();
		assertEquals(todoList,todos);
	}
	
	@Test
	void testCreateTodo() {
		
		factory=factory.getInstance();
		DAOTodo tododao=new DAOTodo(factory);
		Todo todo = new Todo();
		todo.setTodo_delai("02/02/2021");
		todo.setTodo_description("test");
		todo.setTodo_isdone(false);
		todo.setTodo_title("test");
		todo.setTodo_id(5);
		tododao.CreateTodo(todo, 1);
		
		
	}

}
