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
	private static int TAILLE_PAGE = 4;
       
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
		String elm_name = request.getParameter("find");
		
		if(elm_name == null || elm_name.equals("null")||elm_name.trim().equals("")) {
			ArrayList<Module> module = getUserModules(user);
			request.setAttribute("nbpages", ((module.size()-1)/this.TAILLE_PAGE));
			request.setAttribute("search", false);
			int requestedPage=0;
			try {
			  requestedPage = Integer.parseInt(request.getParameter("page"));
			}catch(NumberFormatException e) {
				requestedPage=0;
			}
			request.setAttribute("requestedPage", (requestedPage*TAILLE_PAGE>module.size())?0:requestedPage);
			module = this.getDisplayedModules(module, TAILLE_PAGE, requestedPage*TAILLE_PAGE);
			
			request.setAttribute("modules", module);
			this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(request, response);
		}
		else {
			//Search procedure
			request.setAttribute("search", true);
			ArrayList<Module> module = daoModule.findModuleByName(elm_name);
			System.out.println(module.size());
			request.setAttribute("modules", module);
			this.getServletContext().getRequestDispatcher(ROOT+JSP).forward(request, response);
		}
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
	private ArrayList<Module> getDisplayedModules(ArrayList<Module> modules,int taille,int index){
		ArrayList<Module> mod = new ArrayList<>();
		if(modules.size()<index) index =0;
		for(int i =index;i<(index+taille);i++) {
			if(i<modules.size()) {
				mod.add(modules.get(i));
			}
		}
		return mod;
	}

}
