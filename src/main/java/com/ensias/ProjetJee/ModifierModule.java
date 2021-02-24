package com.ensias.ProjetJee;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import com.ensias.beans.Module;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensias.Forms.ModuleForm;

public class ModifierModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModuleDao daoModule;
	private static final String ATT_DAO_FACTORY = "daofactory";
       
    private static final String AssetsRoot = "/Assets/Modules/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierModule() {
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
		response.sendRedirect("/ensiasdocs/admin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("examen")==null || request.getParameter("examen").equals("null")||request.getParameter("examen").equals("")) {
			ModuleForm form = new ModuleForm(request);
			Module module = form.validerModule();
			ArrayList<String> filieres = form.getFilieres();
			if(module.getElm_id()!=-1 && (module.getElm_description()!=null || module.getElm_module()!=null ||module.getElm_annee()!=null || module.getElm_semester()!=null||filieres.size()>0)) {
				daoModule.updateModule(module, filieres);	
			}
		}else {
			try {
			String exam = request.getParameter("examen");
			int id = Integer.parseInt(request.getParameter("elm_module"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.parse(exam);
			daoModule.ajouterExam(exam, id);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("/ensiasdocs/admin");
	}

}
