package com.ensias.ProjetJee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensias.beans.User;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;
import com.ensias.beans.Module;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	 public static String ROOT = "/WEB-INF/";
	 public static String JSP = "Home.jsp";
	 
	 ModuleDao daoModule;
	    
	 private static final String ATT_DAO_FACTORY = "daofactory";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
        super.init();
        //Get the Dao
        daoModule = ((DaoFactory) this.getServletContext().getAttribute(ATT_DAO_FACTORY)).getModuleDao();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Module> module = getUserModules(user);
		request.setAttribute("modules", module);
		this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private ArrayList<Module> getUserModules(User user) {
		ArrayList<Module> modules = daoModule.findModuleByUser(user);
		return modules;
	}
	//TEMP
	private Module generateModule() {
		Module module = new Module();
		module.setElm_id((int)(Math.random()*1000));
		module.setElm_name("Analyse de données");
		module.setElm_module("Statistique et analyse de données");
		return module;	
	}

}
