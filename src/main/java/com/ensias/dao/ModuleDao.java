package com.ensias.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ensias.beans.User;
import com.ensias.beans.Document;
import com.ensias.beans.Module;

public class ModuleDao {
	DaoFactory factory;
	public static String Table = "element";
	public static String ID =  "elm_id";
	public static String name =  "elm_name" ;
	public static String module_elm =  "elm_module"; 
	public static String description =  "elm_description"; 
	public static String annee = "elm_annee"; 
	public static String semester =  "elm_semester"; 
	public static String exam = "date_exam";
	public static String Association = "inscrit";
	public static String Association_elm_id = "id_elm";
	public static String Association_user_id = "id_user";
	
	public ModuleDao(DaoFactory factory){
		this.factory = factory;
	}
	//Function that returns all user's modules
	public ArrayList<Module> findModuleByUser(User user){
		Connection connexion = null;
		ArrayList<Module> modules = new ArrayList<>();
		
		try {
			connexion = factory.getConnection();
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM " +Table+" JOIN "+Association+" ON "+Association_elm_id+"="+ID+" WHERE "+Association_user_id +"=?;");
			statement.setInt(1, user.getId());
			ResultSet set = statement.executeQuery();
			ResultSetMetaData meta = set.getMetaData();
			while(set.next()) {
				Module module = new Module();
				module.setElm_id(set.getInt(ID));
				System.out.println(set.getString(name));
				module.setElm_name(set.getString(name));
				module.setElm_module(set.getString(module_elm));
				module.setElm_annee(set.getString(annee));
				module.setElm_semester(set.getString(semester));
				module.setDate_exam(set.getDate(exam));
				module.setElm_description(set.getString(description));
				modules.add(module);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connexion!=null)
				try {
					connexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return modules;
	}
	public Module findModuleById(int Id){
		Connection connexion = null;
		
		
		try {
			connexion = factory.getConnection();
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM " +Table+" WHERE "+ID +"=?;");
			statement.setInt(1, Id);
			ResultSet set = statement.executeQuery();
			if(set.next()) {
				Module module = new Module();
				module.setElm_id(Id);
				module.setElm_name(set.getString("elm_name"));
				module.setElm_module(set.getString("elm_module"));
				module.setElm_annee(set.getString("elm_annee"));
				module.setElm_semester(set.getString("elm_semester"));
				module.setDate_exam(set.getDate("date_exam"));
				module.setElm_description(set.getString("elm_description"));
				return module;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connexion!=null)
				try {
					connexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	//Function that returns documents for a module
	
	public ArrayList<Document> findModuleDocuments(int elm_id){
		
		ArrayList<Document> docs = new ArrayList<>();
		Connection conn = null;
		try {
			conn = factory.getConnection();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM document WHERE doc_elm=?;");
			stm.setInt(1, elm_id);
			ResultSet set = stm.executeQuery();
			while(set.next()) {
				Document doc = new Document();
				doc.setDoc_id(set.getInt("doc_id"));
				doc.setDoc_name(set.getString("doc_name"));
				doc.setDoc_mime(set.getString("doc_mime"));
				doc.setDoc_path(set.getString("doc_path"));
				doc.setDoc_type(set.getString("doc_type"));
				doc.setDoc_elm(set.getInt("doc_elm"));
				docs.add(doc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return docs;
		
	}
public Document findDocumentsById(int id){
		
		
		Connection conn = null;
		try {
			conn = factory.getConnection();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM document WHERE doc_id=?;");
			stm.setInt(1, id);
			ResultSet set = stm.executeQuery();
			if(set.next()) {
				Document doc = new Document();
				doc.setDoc_id(set.getInt("doc_id"));
				doc.setDoc_name(set.getString("doc_name"));
				doc.setDoc_mime(set.getString("doc_mime"));
				doc.setDoc_path(set.getString("doc_path"));
				doc.setDoc_type(set.getString("doc_type"));
				doc.setDoc_elm(set.getInt("doc_elm"));
				return doc;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
