package com.ensias.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
	private int todo_id;
    private String todo_title;
    private String todo_description;
    private String todo_delai;
    private boolean todo_isdone;
    private boolean todo_isclose;
    
    
    //Const
    public Todo() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    //getters
    public int getTodo_id() {
        return todo_id;
    }

    public String getTodo_delai() {
        return todo_delai;
    }
    
    public boolean getTodo_isdone() {
        return this.todo_isdone;
    }

    public String getTodo_description() {
        return todo_description;
    }

    public String getTodo_title() {
        return todo_title;
    }
    //setters
    public void setTodo_delai(String todo_delai) {
        this.todo_delai = todo_delai;
    }

    public void setTodo_description(String todo_description) {
        this.todo_description = todo_description;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public void setTodo_isdone(boolean todo_isdone) {
        this.todo_isdone = todo_isdone;
    }

    public void setTodo_title(String todo_title) {
        this.todo_title = todo_title;
    }
    public boolean getTodo_isclose() {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(this.todo_delai);
			Date now = new Date();
			if(date.getMonth() == now.getMonth() && date.getYear() == now.getYear() ) {
				this.todo_isclose = (date.getDate() -now.getDate())<2;
				System.out.println(date.toString());
				System.out.println(date.getDate());
				return this.todo_isclose;
			}else {
				return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    }

}
