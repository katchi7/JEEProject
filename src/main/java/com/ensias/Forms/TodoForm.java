package com.ensias.Forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ensias.ProjetJee.Calendrier;
import com.ensias.beans.Todo;

public class TodoForm {
	
	private static String TODO_NAME = "todo_name";
	private static String TODO_DATE = "todo_date";
	private static String TODO_DESC = "todo_desc";
	private static String TODO_DONE = "todo_is_done";
	
	HashMap<String,String> errors = new HashMap<>();
	private HttpServletRequest request;
	
	public TodoForm(HttpServletRequest request) {
		this.request = request;
	}
	
	public Todo inscrireTache() {
		Todo todo = new Todo();
		todo.setTodo_isdone("done".equals(request.getParameter(TODO_DONE)));
		try {
			todo.setTodo_delai(this.validerDate(request.getParameter(TODO_DATE)));
		}  catch (Exception e) {
			errors.put(TODO_DATE, e.getMessage());
		}
		
		try {
			todo.setTodo_description(request.getParameter(TODO_DESC));
		} catch (Exception e) {
			errors.put(TODO_DESC, e.getMessage());
		}
		try {
			validerName(request.getParameter(TODO_NAME));
			todo.setTodo_title(request.getParameter(TODO_NAME));
		} catch (Exception e) {
			errors.put(TODO_NAME, e.getMessage());
		}
		return todo;
	}
	
	private void validerName(String todo_name) throws Exception {
		if(todo_name == null || todo_name.equals("null")) {
			throw new Exception("Le nom ne doit pas etre null");
		}
		if(todo_name.length()<3) throw new Exception("Le nom doit contenir au moin 3 caractéres");
		
	}
	
	private String validerDate(String todo_date)throws Exception {
		HttpSession session = request.getSession();
		String src = (String)session.getAttribute(Calendrier.TODO_FORM);
		if(!src.equals("/ensiasdocs/todo")) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy hh:mm a");
		Date date = dateFormat.parse(todo_date);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
		todo_date =  dateFormat.format(date).toString();
		}else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.parse(todo_date);
		}
		return todo_date;
	}
	
	public HashMap<String,String> getErrors(){
		return this.errors;
	}
}
