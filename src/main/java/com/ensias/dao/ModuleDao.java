package com.ensias.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ensias.beans.User;
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

}
