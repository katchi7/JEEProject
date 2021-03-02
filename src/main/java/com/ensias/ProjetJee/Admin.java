package com.ensias.ProjetJee;

import java.io.IOException;
import java.util.ArrayList;
import com.ensias.beans.Module;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ATT_DAO_FACTORY = "daofactory";
    private static final String AssetsRoot = "/Assets/Modules/";
	private ModuleDao daoModule;       
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

 
 

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
		ArrayList<Module> modules = daoModule.findAllModules();
		System.out.println(modules.size());
		request.setAttribute("modules", modules);
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
