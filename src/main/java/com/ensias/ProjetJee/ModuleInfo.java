package com.ensias.ProjetJee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensias.beans.Document;
import com.ensias.beans.User;
import com.ensias.beans.Module;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;


public class ModuleInfo extends HttpServlet {
	
	private	ModuleDao daoModule;
	 private static final String ATT_DAO_FACTORY = "daofactory";
       
   
    public ModuleInfo() {
        super();
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
			Module module= daoModule.findModuleById(id);
			if(module!=null) {
				request.setAttribute("module", module);
				boolean inscrit = daoModule.userIsInscrit(user.getId(), id);
				if(inscrit) {
					ArrayList<Document> docs = this.getDocs(id,module);
					
					request.setAttribute("docs", docs);
					request.setAttribute("types",this.getTypes(docs));
				}
				
				
				request.setAttribute("inscrit", inscrit);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/module.jsp").forward(request,response);
			}else {
				response.sendRedirect("/ensiasdocs/home");
			}
			
		}catch(Exception e) {
			response.sendRedirect("/ensiasdocs/home");
		}
		
	}
	
	private ArrayList<Document> getDocs(int id,Module module) throws Exception{
		
		if(module != null) {
			ArrayList<Document> docs = daoModule.findModuleDocuments(id);
			return docs;
		}
		else throw new Exception("Docs");
	}
	private ArrayList<String> getTypes(ArrayList<Document> docs){
		ArrayList<String> types = new ArrayList<>();
		for(Document doc : docs) {
			if(!types.contains(doc.getDoc_type())) types.add(doc.getDoc_type());
		}
		return types;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id")); 
			User user =(User) request.getSession().getAttribute("user");
			Module module = daoModule.findModuleById(id);
			if(module==null) {
				response.sendRedirect("/ensiasdocs/home");
			}else {
				daoModule.inscrireUser(user.getId(), id);
				response.sendRedirect(request.getRequestURL().toString());
			}
		}catch(NumberFormatException e){
			response.sendRedirect("/ensiasdocs/home");
		}
		 
	}

}
