package com.ensias.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<Todo> getTodoByUser(int user_id){
		ArrayList<Todo> todos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet set = null;
		
		try {
			conn = factory.getConnection();
			stm = conn.prepareStatement("SELECT * FROM todos WHERE todo_user=?");
			stm.setInt(1, user_id);
			set = stm.executeQuery();
			while(set.next()) {
				Todo todo = new Todo();
				todo.setTodo_id(set.getInt("todo_id"));
				todo.setTodo_title(URLDecoder.decode(new String(set.getString("todo_title").getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				if(set.getString("todo_description")!=null) {
					todo.setTodo_description( URLDecoder.decode(new String(set.getString("todo_description").getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				}
				
				todo.setTodo_isdone(set.getBoolean("todo_is_done"));
				todo.setTodo_delai(set.getDate("todo_delai").toString());
				todos.add(todo);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
		
			e.printStackTrace();
		}finally {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return todos;
	}
	
	 
}
