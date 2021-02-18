package com.ensias.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ensias.beans.Todo;

public class DAOTodo {

	private static String TODO_TABLE = "todos";
	private static String TODO_TITLE = "todo_title";
	private static String TODO_ID = "todo_id";
	private static String TODO_DESC = "todo_description";
	private static String TODO_DELAI = "todo_delai";
	private static String TODO_DONE = "todo_is_done";
	private static String TODO_USER = "todo_user";
	
	private DaoFactory factory;
	public DAOTodo(DaoFactory factory) {
		this.factory = factory;
	}
	
	public void CreateTodo(Todo todo,int id) {
		
		Connection conn = null;
		
		try {
			conn = factory.getConnection();
			PreparedStatement stm = conn.prepareStatement("INSERT INTO "+ TODO_TABLE+ "("+TODO_TITLE+","+TODO_DESC+ ","+TODO_DONE+ ","+TODO_DELAI+ ","+TODO_USER+") VALUES (?,?,?,?,?);");
			stm.setString(1, todo.getTodo_title());
			stm.setString(2,todo.getTodo_description());
			stm.setBoolean(3,todo.getTodo_isdone());
			stm.setString(4,todo.getTodo_delai());
			stm.setInt(5,id);
			stm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	 
}
