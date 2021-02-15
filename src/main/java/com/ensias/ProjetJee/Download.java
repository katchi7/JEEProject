package com.ensias.ProjetJee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensias.beans.Document;
import com.ensias.dao.DaoFactory;
import com.ensias.dao.ModuleDao;

public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModuleDao daoModule;
    
	 private static final String ATT_DAO_FACTORY = "daofactory";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        super.init();
        //Get the Dao
        daoModule = ((DaoFactory) this.getServletContext().getAttribute(ATT_DAO_FACTORY)).getModuleDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//get the id
		int id = Integer.parseInt(request.getRequestURI().split("/")[3]);
		//get the document
		Document doc = this.getDoc(id);
		//forcing the download (to avoid the navigator's default behaviour)
		response.setHeader("Content-Disposition", "attachment; filename=\""+doc.getDoc_name()+"\"");
		//Getting file path and mime
		String path = this.getServletContext().getRealPath(doc.getDoc_path());
		response.setContentType(doc.getDoc_mime());
		//reading the file and sending to the user
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(path)));
		BufferedOutputStream out =new BufferedOutputStream( response.getOutputStream());
		byte[] b = new byte[100];
		int bytes = -1;
		while ((bytes = in.read(b))!=-1) {
			out.write(b,0,bytes);
		}
		//closing
		in.close();
		out.close();
		}catch(IOException e) {
			e.printStackTrace();
			//the file does not exist
			response.sendRedirect("/error");
		}
		catch(Exception e) {
			//Exceptions (parsing the int or doc not found)
			response.sendRedirect("/error");
		}
	}
	private Document getDoc(int id) throws Exception {
		Document doc = daoModule.findDocumentsById(id);
		if(doc == null) throw new Exception("Document not found");
		return doc;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
