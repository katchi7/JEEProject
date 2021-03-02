package com.ensias.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;


import com.ensias.beans.Todo;
import com.ensias.beans.User;
import com.ensias.dao.DAOTodo;
import com.ensias.dao.DAOUser;

class DAOTodoTest {

	@BeforeEach
	void setUp() throws Exception {
	}


	@Mock
    private DAOTodo daotodo; 
	
	@Test
	void testCreateTodo() {
		
		Todo sampleTodo = new Todo();
		Todo todo1 =new Todo();
		List<Todo> todoMap = new ArrayList<>();
		DAOTodo dao = Mockito.mock(DAOTodo.class);
		when(dao.CreateTodo(sampleTodo, 1)).thenAnswer(i ->{
			Todo todo2=i.getArgument(0);
			todoMap.add(todo2.getTodo_id(), todo1);
			return null;
			
		});
	}
}
