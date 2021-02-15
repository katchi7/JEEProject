package com.ensias.ProjetJee;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensias.beans.Document;

import com.ensias.beans.User;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

public class DocServlet extends HttpServlet {
	private ModuleDao daoModule;
	private static final String ATT_DAO_FACTORY = "daofactory";
       
    
    public DocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
   
    public void init() throws ServletException {
        super.init();
        //Get the Dao
        daoModule = ((DaoFactory) this.getServletContext().getAttribute(ATT_DAO_FACTORY)).getModuleDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User user =(User) request.getSession().getAttribute("user");
			int id = Integer.parseInt( request.getRequestURI().split("/")[3]);
			Document doc = daoModule.findDocumentsById(id);
			request.setAttribute("doc", doc);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Document.jsp").forward(request,response);
		}catch(Exception e) {
			response.sendRedirect("/error");
		}
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
