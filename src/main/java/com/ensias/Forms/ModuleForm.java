package com.ensias.Forms;

import java.util.ArrayList;
import java.util.HashMap;

import com.ensias.beans.Module;
import javax.servlet.http.HttpServletRequest;

public class ModuleForm {
	private static String ELEMENT_NAME = "elm_module";
	private static String MODULE_NAME = "module";
	private static String MODULE_ANNEE = "annee";
	private static String MODULE_SEMESTER = "semestre";
	private static String MODULE_DSC = "dscModule";
	private HashMap<String,String> errors = new HashMap<>();
	private static final ArrayList<String> NIVEAUX = new ArrayList<String>();
    static {
    	NIVEAUX.add("1A");
    	NIVEAUX.add("2A");
    	NIVEAUX.add("3A");
    }
    private static final ArrayList<String> FILIERES = new ArrayList<String>();
    static {
    	FILIERES.add("GL");
    	FILIERES.add("IWIM");
    	FILIERES.add("eMBI");
    	FILIERES.add("IeL");
    	FILIERES.add("ISEM");
    	FILIERES.add("SSI");
    	FILIERES.add("2IA");
    	FILIERES.add("IDF");
    }
    
    private HttpServletRequest request;
    
    public ModuleForm(HttpServletRequest request) {
    	this.request = request;
    }
    
    
    public Module inscrireModule() {
    	Module module = new Module();
    	try {
			this.validate_text(request.getParameter(MODULE_NAME));
			module.setElm_module(request.getParameter(MODULE_NAME));
		} catch (Exception e) {
			this.errors.put(MODULE_NAME, e.getMessage());
		}
    	try {
			this.validate_text(request.getParameter(ELEMENT_NAME));
			module.setElm_name(request.getParameter(ELEMENT_NAME));
		} catch (Exception e) {
			this.errors.put(ELEMENT_NAME, e.getMessage());
		}
    	try {
			this.validate_text(request.getParameter(MODULE_DSC));
			module.setElm_description(request.getParameter(MODULE_DSC));
		} catch (Exception e) {
			this.errors.put(MODULE_DSC, e.getMessage());
		}
    	
    	try {
			this.validate_annee(request.getParameter(MODULE_ANNEE));
			module.setElm_annee(request.getParameter(MODULE_ANNEE));
		} catch (Exception e) {
			errors.put(MODULE_ANNEE, e.getMessage());
		}
    	
    	try {
			this.validate_semester(request.getParameter(MODULE_SEMESTER));
			module.setElm_semester(request.getParameter(MODULE_SEMESTER));
		} catch (Exception e) {
			errors.put(MODULE_SEMESTER, e.getMessage());
		}
    	return module;
    }
    
    public Module validerModule() {
    	Module module = new Module();
    	try {
			this.validate_text(request.getParameter(MODULE_NAME));
			module.setElm_module(request.getParameter(MODULE_NAME));
		} catch (Exception e) {
			this.errors.put(MODULE_NAME, e.getMessage());
		}
    	try {
			module.setElm_id(this.validate_id(request.getParameter(ELEMENT_NAME)));
		} catch (Exception e) {
			module.setElm_id(-1);
			this.errors.put(ELEMENT_NAME, e.getMessage());
		}
    	try {
			this.validate_text(request.getParameter(MODULE_DSC));
			module.setElm_description(request.getParameter(MODULE_DSC));
		} catch (Exception e) {
			this.errors.put(MODULE_DSC, e.getMessage());
		}
    	
    	try {
			this.validate_annee(request.getParameter(MODULE_ANNEE));
			module.setElm_annee(request.getParameter(MODULE_ANNEE));
		} catch (Exception e) {
			errors.put(MODULE_ANNEE, e.getMessage());
		}
    	
    	try {
			this.validate_semester(request.getParameter(MODULE_SEMESTER));
			module.setElm_semester(request.getParameter(MODULE_SEMESTER));
		} catch (Exception e) {
			errors.put(MODULE_SEMESTER, e.getMessage());
		}
    	return module;
    }
    
    
    
    public ArrayList<String> getFilieres(){
    	ArrayList<String> filieres = new ArrayList<>();
    	
    	for(String s : FILIERES) {
    		if(request.getParameter(s) != null && !"null".equals(request.getParameter(s))){
    			filieres.add(request.getParameter(s));
    		}
    	}
    	
		return filieres;
    	
    }
    
    private void validate_text(String module) throws Exception{
    	if(module==null || module.equals("null")) {
    		throw new Exception("Le nom du module ne doit pas etre null");
    	}
    	if(module.length()<4) {
    		throw new Exception("Le nom doit contenir au moins 3 lettres");
    	}
    }
    
    private void validate_annee(String annee) throws Exception {
    	if(annee == null || annee.equals("null")) {
    		throw new Exception("Le Champ annee ne doit pas etre null");
    	}
    	if(!NIVEAUX.contains(annee)) throw new Exception("Choisissez un niveau valide");
    }
    
    private void validate_semester(String semester) throws Exception {
    	if(semester == null || semester.equals("null")) {
    		throw new Exception("Le Champ semestre ne doit pas etre null");
    	}
    }
    private int validate_id(String id) throws Exception {
    	int id_ = -1;
    	try {
    		id_ = Integer.parseInt(id);
    		return id_;
    	}catch(NumberFormatException e) {
    		throw new Exception("Module Invalide");    	
    	}
    	
    }
    public HashMap<String,String> getErrors(){
    	return this.errors;
    }
}
