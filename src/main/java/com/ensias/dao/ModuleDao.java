package com.ensias.dao;

import java.io.UnsupportedEncodingException;
import static java.nio.charset.StandardCharsets.*;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
				System.out.println(URLDecoder.decode(new String(set.getString(name).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8") );
				module.setElm_name( URLDecoder.decode(new String(set.getString("elm_name").getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				module.setElm_module( URLDecoder.decode(new String(set.getString("elm_module").getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				module.setElm_annee(set.getString("elm_annee"));
				module.setElm_semester(set.getString(semester));
				module.setDate_exam(set.getDate(exam));
				module.setElm_description(URLDecoder.decode(new String(set.getString("elm_description").getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				modules.add(module);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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
				module.setElm_name( URLDecoder.decode(new String(set.getString("elm_name").getBytes(), StandardCharsets.UTF_8), StandardCharsets.UTF_8) );
				module.setElm_module(URLDecoder.decode(new String(set.getString("elm_module").getBytes(), StandardCharsets.UTF_8), StandardCharsets.UTF_8));

				module.setElm_annee(set.getString("elm_annee"));
				module.setElm_semester(set.getString("elm_semester"));
				module.setDate_exam(set.getDate("date_exam"));
				module.setElm_description( URLDecoder.decode(new String(set.getString("elm_description").getBytes(), StandardCharsets.UTF_8), StandardCharsets.UTF_8) );
				return module;
			}
		} catch (SQLException e ) {
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
				doc.setDoc_id(set.getInt("doc_id") );
				doc.setDoc_name(URLDecoder.decode(new String(set.getString("doc_name").getBytes(), StandardCharsets.UTF_8), StandardCharsets.UTF_8));
				doc.setDoc_mime(set.getString("doc_mime"));
				doc.setDoc_path( URLDecoder.decode(new String(set.getString("doc_path").getBytes(), StandardCharsets.UTF_8), StandardCharsets.UTF_8));
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
				doc.setDoc_name( URLDecoder.decode(new String(set.getString("doc_name").getBytes(), StandardCharsets.UTF_8), StandardCharsets.UTF_8));
				doc.setDoc_mime(set.getString("doc_mime")  );
				doc.setDoc_path( URLDecoder.decode(new String(set.getString("doc_path").getBytes(), StandardCharsets.UTF_8), StandardCharsets.UTF_8));
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

	public void creerModules(Module module , ArrayList<String> filieres) {
			Connection conn = null;
			try {
				conn = factory.getConnection();
				
				PreparedStatement stm = conn.prepareStatement("INSERT INTO element(elm_name,elm_module,elm_description,elm_annee,elm_semester)VALUES(?,?,?,?,?);",PreparedStatement.RETURN_GENERATED_KEYS);
				stm.setString(1, module.getElm_name());
				stm.setString(2, module.getElm_module());
				stm.setString(3,module.getElm_description());
				stm.setString(4, module.getElm_annee());
				stm.setString(5, module.getElm_semster());
				stm.execute();
				ResultSet set  = stm.getGeneratedKeys();
				set.next();
				int id = set.getInt(1);
				module.setElm_id(id);
				if(filieres.size()>0){
					String query = "INSERT INTO filiere_element VALUES";
					for (String filiere : filieres) {
						query += "('"+filiere+"','"+id+ "'),";
					}
					query = query.substring(0,query.lastIndexOf(','))+";";
					stm = conn.prepareStatement(query);
					stm.execute();
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
	}
	
	public ArrayList<Module> findAllModules(){
		ArrayList<Module> modules = new ArrayList<>();
		Connection conn = null;
		try {
			conn =  factory.getConnection();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM element;");
			ResultSet set = stm.executeQuery();
			while(set.next()) {
				Module m = new Module();
				m.setElm_id(set.getInt(this.ID));
				m.setElm_name( URLDecoder.decode(new String(set.getString(this.name).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				m.setElm_module( URLDecoder.decode(new String(set.getString(this.module_elm).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8") );
				m.setElm_description(URLDecoder.decode(new String(set.getString(this.description).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8")  );
				m.setElm_annee(set.getString(this.annee));
				m.setElm_semester(set.getString(this.semester));
				modules.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return modules;
		
	}
	
	public void CreateDocs(ArrayList<Document> docs) {
		
		String query = "INSERT INTO document (doc_name,doc_path,doc_type,doc_mime,doc_elm) VALUES";
		for(Document doc : docs) {
			query+="('"+doc.getDoc_name().replace("'", "\\'")+"','"+doc.getDoc_path().replace("'", "\\'")+"','"+doc.getDoc_type().replace("'", "\\'")+"','"+doc.getDoc_mime()+"','"+doc.getDoc_elm()+"'),";
		}
		query = query.substring(0,query.lastIndexOf(','))+";";
		System.out.println(query);
		
		Connection conn = null;
		try {
			conn = factory.getConnection();
			PreparedStatement stm = conn.prepareStatement(query); 
			stm.execute();
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
		
		
		
		
	}
	
	public void updateModule(Module module,ArrayList<String> filieres) {
		String query ="";
		Connection conn=null;
		try {
			conn = factory.getConnection();
			conn.setAutoCommit(false);
			Statement stm = conn.createStatement();
		if(module.getElm_description()!=null || module.getElm_module()!=null ||module.getElm_annee()!=null || module.getElm_semster()!=null){
			query +="UPDATE element SET";
			if(module.getElm_module()!=null) {
					module.setElm_module(module.getElm_module().replace("'", "\\'"));
				System.out.print(module.getElm_module());
				query+=" elm_module='"+module.getElm_module()+"',";
				}
			if(module.getElm_description()!=null) {   query+=" elm_description ='"+module.getElm_description().replace("'", "\\'")+"',"; }
			if(module.getElm_annee()!=null) query+="elm_annee='"+module.getElm_annee()+"',";
			if(module.getElm_semster()!=null) query+="elm_semester='"+module.getElm_semster()+"',";
			query = query.substring(0,query.lastIndexOf(','))+" WHERE elm_id='"+module.getElm_id()+"';\n";
			System.out.println(query);
			stm.addBatch(query);
			query = "";			
		}
		if(filieres.size()>0){
			query += "DELETE FROM filiere_element WHERE id_elm = "+module.getElm_id();
			System.out.println(query);
			stm.addBatch(query);
			query = "INSERT INTO filiere_element VALUES";
			for (String filiere : filieres) {
				query += "('"+filiere+"','"+module.getElm_id()+ "'),";
			}
			query = query.substring(0,query.lastIndexOf(','))+";";
			stm.addBatch(query);
			
		}
		stm.executeBatch();
		conn.commit();
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
		
		
	}
	public ArrayList<Module> findModuleByName(String name) {
		ArrayList<Module> modules = new ArrayList<Module>();
		
		Connection conn=null;
		PreparedStatement stm = null;
		ResultSet set = null;
		try {
			conn = factory.getConnection();
			stm = conn.prepareStatement("SET NAMES utf8;");
			stm.execute();
			stm.close();
			
			stm = conn.prepareStatement("SELECT * FROM element;");
			
			System.out.println(stm);
			System.out.println(name);
			set = stm.executeQuery();
			while(set.next()) {
				Module m = new Module();
				m.setElm_id(set.getInt(this.ID));
				m.setElm_name( URLDecoder.decode(new String(set.getString(this.name).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				m.setElm_module( URLDecoder.decode(new String(set.getString(this.module_elm).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8") );
				m.setElm_description(URLDecoder.decode(new String(set.getString(this.description).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8")  );
				m.setElm_annee(set.getString(this.annee));
				m.setElm_semester(set.getString(this.semester));
				modules.add(m);
			}
			ArrayList<Module> temp = new ArrayList<Module>();
			for(int i=0;i<modules.size();i++) {
				if(modules.get(i).getElm_name().equals(name)) temp.add(modules.get(i));
			}
			modules.clear();
			modules = temp;
			
		} catch (SQLException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(set!=null)
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(stm!=null)
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				try {
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return modules;
	}
}
