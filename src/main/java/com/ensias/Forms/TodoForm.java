package com.ensias.Forms;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

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
			e.printStackTrace();
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
		if(todo_name.length()<3) throw new Exception("Le nom doit contenir au moin 3 caract�res");
		
	}
	
	private String validerDate(String todo_date)throws Exception {
		
		HttpSession session = request.getSession();
		String src = (String)session.getAttribute(Calendrier.TODO_FORM);
		if(!src.equals("/ensiasdocs/todo")) {
			String[] date_splitted =  todo_date.split(" ");
			todo_date = date_splitted[0]+" " + date_splitted[1] +" "+ date_splitted[2];
		DateFormatSymbols DFS = new DateFormatSymbols();
		DFS.setMonths(new String[] {
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December"
		});
		System.out.println(todo_date);
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMMM u", Locale.ENGLISH);
	    LocalDate date = LocalDate.parse(todo_date, dateFormatter);
	    todo_date = date.toString();
		}else {
			System.out.println(todo_date);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.parse(todo_date);
		}
		return todo_date;
	}
	
	public HashMap<String,String> getErrors(){
		return this.errors;
	}
}
