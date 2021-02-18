package com.ensias.beans;



public class Todo {
	private int todo_id;
    private String todo_title;
    private String todo_description;
    private String todo_delai;
    private boolean todo_isdone;
    
    
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
    

}
