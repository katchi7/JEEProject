package com.ensias.dao;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ensias.beans.Event;
public class DaoEvent {

	private static String element="element";
	private static String todo = "todos";
	private static String elm_id = "elm_id";
	private static String elm_name = "elm_name";
	private static String elm_module = "elm_module";
	private static String elm_description = "elm_description";
	private static String elm_annee = "elm_annee";
	private static String elm_semester = "elm_semester";
	private static String elm_exam = "date_exam";
	private static String todo_id = "todo_id";
	private static String todo_title = "todo_title";
	private static String todo_description = "todo_description";
	private static String todo_is_done = "todo_is_done";
	private static String todo_delai = "todo_delai";
	private DaoFactory factory;
	
	public DaoEvent(DaoFactory factory){
		this.factory = factory;
	}
	
	
	public ArrayList<Event> findUserEvents(int id){
		ArrayList<Event> ev = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = factory.getConnection();
			stm = conn.prepareStatement("SELECT * FROM "+this.element+" JOIN inscrit on id_elm="+elm_id+" WHERE id_user = ? and date_exam is not null; ");
			stm.setInt(1, id);
			ResultSet set = stm.executeQuery();
			while(set.next()) {
				Event event = new Event();
				event.setEvent_name( URLDecoder.decode(new String(set.getString(elm_name).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				event.setEvent_description(URLDecoder.decode(new String(set.getString(elm_description).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				event.setEvent_start(set.getDate(elm_exam).toString());
				event.setEvent_end(set.getDate(elm_exam).toString());
				event.setEvent_class("fc-bg-blue");
				event.setEvent_icon("laptop-code");
				ev.add(event);
			}
			stm = conn.prepareStatement("SELECT * FROM "+this.todo+" WHERE todo_user = ? ;");
			stm.setInt(1, id);
			set = stm.executeQuery();
			while(set.next()) {
				Event event = new Event();
				event.setEvent_name(URLDecoder.decode(new String(set.getString(todo_title).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8"));
				event.setEvent_description(URLDecoder.decode(new String(set.getString(todo_description).getBytes("ISO-8859-1"), "UTF-8"), "UTF-8") );
				event.setEvent_start(set.getDate(todo_delai).toString());
				event.setEvent_end(set.getDate(todo_delai).toString());
				event.setEvent_class("fc-bg-default");
				event.setEvent_icon("laptop-code");
				ev.add(event);
			}
		} catch (SQLException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stm.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ev;
		
	}
}
