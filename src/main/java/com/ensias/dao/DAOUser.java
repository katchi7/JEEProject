package com.ensias.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ensias.beans.User;

public class DAOUser {
	DaoFactory factory;
	public static String TABLE_NAME = "user";
	public static String ID = "user_id";
	public static String F_NAME = "user_f_name";
	public static String L_NAME = "user_l_name";
	public static String EMAIL = "user_email";
	public static String PASSWORD = "user_password";
	public static String ADMIN = "user_is_admin";
	public static String NUM = "user_num";
	public static String NV = "user_nv";
	public static String FILIERE = "user_filiere";
	
	DAOUser(DaoFactory factory){
		this.factory = factory;
	}
	public boolean Create(User user) {
		Connection connection = null;
		try {
			connection = factory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+TABLE_NAME+"("+F_NAME+","+L_NAME+","+EMAIL+","+PASSWORD+","+ADMIN+ ","+NUM+","+NV+","+FILIERE+")"
					+ "VALUES ('" +user.getFname()+"','"+user.getLname()+"','"+user.getEmail()+"','"+user.getPasswordAsHash()+"',?,'"+user.getNum()+"','"+user.getNiveau()+"','"+user.getFiliere()+"');");
			preparedStatement.setBoolean(1, user.isAdministrator());
			preparedStatement.execute();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
			return false;
		}
	}
	public User  findUser(String User_email ) {
		Connection connection = null;
		try {
			connection = factory.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE "+EMAIL+"=?;");
			preparedStatement.setString(1, User_email);
			ResultSet set = preparedStatement.executeQuery();
			if(set.next()) {
				User user = new User();
				int index = 0;
				index = set.findColumn(ID);
				user.setId(set.getInt(index));
				index = set.findColumn(F_NAME);
				user.setFname(set.getString(index));
				index = set.findColumn(L_NAME);
				user.setLname(set.getString(index));
				index = set.findColumn(EMAIL);
				user.setEmail(set.getString(index));
				index = set.findColumn(PASSWORD);
				user.setPassword(set.getString(index));
				index = set.findColumn(NV);
				user.setNiveau(set.getString(index));
				index = set.findColumn(ADMIN);
				user.setAdministrator(set.getBoolean(index));
				index = set.findColumn(NUM);
				user.setNum(set.getString(index));
				index = set.findColumn(FILIERE);
				user.setFiliere(set.getString(index));
				connection.close();
				return user;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
