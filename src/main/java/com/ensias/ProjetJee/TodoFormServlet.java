package com.ensias.ProjetJee;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensias.Forms.TodoForm;
import com.ensias.beans.Todo;
import com.ensias.beans.User;
import com.ensias.dao.DAOTodo;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;


public class TodoFormServlet extends HttpServlet {
       
	private	DAOTodo daoTodo;
	private static final String ATT_DAO_FACTORY = "daofactory";
    
    public TodoFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

      
  
   public void init() throws ServletException {
       super.init();
       //Get the Dao
       daoTodo = ((DaoFactory) this.getServletContext().getAttribute(ATT_DAO_FACTORY)).getDaoTodo();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute(Calendrier.TODO_FORM, "/ensiasdocs/todo");
		User user =(User )session.getAttribute("user");
		ArrayList<Todo> todos = daoTodo.getTodoByUser(user.getId());
		request.setAttribute("todos", todos);
		this.getServletContext().getRequestDispatcher("/WEB-INF/todo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TodoForm form = new TodoForm(request);
		
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		if(request.getParameter("todo_delete_id") == null || request.getParameter("todo_delete_id").equals("null") ) {
		if(request.getParameter("update_done") == null || request.getParameter("update_done").equals("null") ) {
			Todo todo= form.inscrireTache();
			
			if(form.getErrors().isEmpty()) {
				
				daoTodo.CreateTodo(todo, user.getId());
			}
			else {
				
				for(String key :form.getErrors().keySet()) {
					System.out.println("key : "+form.getErrors().get(key));
				}
			}
		}
		else {
			String done = request.getParameter("update_done");
			if(!done.equals("done") && !done.equals("todo") ) {
				//Invalid request
				System.out.println("Unexpected Argument : "+done);
			}else {
				try {
					int todo_id = Integer.parseInt(request.getParameter("todo_id"));
					boolean is_done = done.equals("done");
					daoTodo.UpdateDone(is_done, todo_id);
				}catch(NumberFormatException ignore) {
					
				}
				
			}
		}
		}else {
			try {
				int todo_id = Integer.parseInt(request.getParameter("todo_delete_id"));
				
				daoTodo.DeleteTodo(todo_id);
			}catch(NumberFormatException ignore) {
				
			}
		}
		
		response.sendRedirect((String)session.getAttribute(Calendrier.TODO_FORM));
		session.setAttribute(Calendrier.TODO_FORM,null);
		
	}

}
