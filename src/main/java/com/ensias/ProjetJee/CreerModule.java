package com.ensias.ProjetJee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import com.ensias.beans.Module;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensias.Forms.ModuleForm;

public class CreerModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModuleDao daoModule;
	private static final String ATT_DAO_FACTORY = "daofactory";
       
    private static final String AssetsRoot = "/Assets/Modules/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerModule() {
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
		response.getWriter().append("Served at: ").append(this.getServletContext().getRealPath(AssetsRoot));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModuleForm form = new ModuleForm(request);
		Module module = form.inscrireModule();
		ArrayList<String> filieres =  form.getFilieres();
		daoModule.creerModules(module, filieres);
		File file = new File(this.getServletContext().getRealPath(AssetsRoot)+module.getElm_id());
		boolean b= file.mkdir();
		System.out.println(b);
		response.sendRedirect("/ensiasdocs/admin");
	}

}
