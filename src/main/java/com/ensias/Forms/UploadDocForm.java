package com.ensias.Forms;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.ensias.beans.Document;

public class UploadDocForm {
	
	private HttpServletRequest request ;
	private HashMap<String,String> errors = new HashMap<String,String>();
	private static final String AssetsRoot = "/Assets/Modules/";
	private ArrayList<Part> partsAl;
	public UploadDocForm(HttpServletRequest request) {
		this.request = request;
	}
	
	
	public ArrayList<Document> CreerDocs() {
		ArrayList<Document> docs = new ArrayList<>();
		partsAl = new ArrayList<>();
		Iterator parts;
		try {
			parts = request.getParts().iterator();
			int i=1;
			while (parts.hasNext()) {
				Document doc = new Document();
				Part part = (Part)parts.next();
				String doc_name = getNomFichier(part);
				if(doc_name !=null) {
					partsAl.add(part);
					doc.setDoc_name(URLDecoder.decode(new String(doc_name.replace("\"", "").getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));  
					try {
						doc.setDoc_type(validate_type(request.getParameter("type"+i)));
					
					} catch (Exception e) {
						errors.put("type"+i, e.getMessage());
					}
					doc.setDoc_mime(part.getContentType());
					try {
						doc.setDoc_elm(validate_Id(request.getParameter("nom_module")));
					} catch (Exception e) {
						errors.put("nom_module", e.getMessage());
					}
					if(errors.isEmpty()) {
						doc.setDoc_path(AssetsRoot+doc.getDoc_elm()+"/"+doc.getDoc_name());
					}
					i++;
					docs.add(doc);
				}
				}
			for(Document doc : docs ) {
				i=0;
				for(Document temp : docs) {
					if(temp.getDoc_name().equals(doc.getDoc_name())) i++;
				}
				if(i>1) errors.put(doc.getDoc_name(), "This doc is repeated");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if(!(docs.size()>0)) errors.put("No doc error", "No doc was uploaded");
		return docs;
		
	}
	
	
	public int validate_Id(String _id) throws Exception{
		try {
		int id = Integer.parseInt(_id);
		return id;
		}catch(Exception e) {
			throw new Exception("Unvalid id");
		}
		
		
	}
	
	private String validate_type(String type) throws Exception {
		if(type == null || type.equals("null")) {
			throw new Exception("Le type ne doit pas etre null");
		}
		type = type.substring(0, 1).toUpperCase()+type.substring(1, type.length()).toLowerCase();
		return type;
	}
	private static String getNomFichier( Part part ) {
	    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	    	
	        if ( contentDisposition.trim().startsWith("filename") ) {
	            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 );
	        }
	    }
	    return null;
	}
	public HashMap<String,String> getErrors(){
    	return this.errors;
    }
	
	public ArrayList<Part> getParts(){
		return this.partsAl;
	}
	
}
