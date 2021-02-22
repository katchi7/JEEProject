package com.ensias.ProjetJee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ensias.Forms.UploadDocForm;
import com.ensias.beans.Document;
import com.ensias.beans.Module;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

public class UploadDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModuleDao daoModule;
	private static final String ATT_DAO_FACTORY = "daofactory";
       
    private static final String AssetsRoot = "/Assets/Modules/";
       
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDoc() {
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

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UploadDocForm form = new UploadDocForm(request);
		try {
			System.out.println(request.getParameter("nom_module"));
			int id = form.validate_Id(request.getParameter("nom_module"));
			Module module = daoModule.findModuleById(id);
			if(module==null) {
				response.sendRedirect("/ensiasdocs/admin");
			}
			else {
				ArrayList<Document> docs = form.CreerDocs();
				if(form.getErrors().isEmpty()) {
					//enregistrer les documents
					daoModule.CreateDocs(docs);
					ArrayList<Part> parts = form.getParts();
					int i=0;
					for(Document doc : docs) {
						save_file(parts.get(i),this.getServletContext().getRealPath(doc.getDoc_path()));
					}
					response.sendRedirect("/ensiasdocs/admin");
				}
				else {
					//erreur
					System.out.println("Error");
					response.sendRedirect("/ensiasdocs/admin");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/ensiasdocs/admin");
		}
		
		
		
	}
	
	
	private void save_file(Part part,String path) throws IOException {
		BufferedInputStream in = new BufferedInputStream(part.getInputStream());
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream( URLDecoder.decode(new String(path.getBytes("ISO-8859-1"), "UTF-8"), "UTF-8")) );
		
		byte[] buffer = new byte[1024];
		int size = 0;
		while((size=in.read(buffer))>0) {
			out.write(buffer,0,size);
		}
		in.close();
		out.close();
	}
}
