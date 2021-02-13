package com.ensias.beans;

import java.sql.Date;

public class Module {
	
	private int elm_id;
	private String elm_name;
	private String elm_module;
	private String elm_annee;
	private String elm_semester;
	private Date date_exam;
	
	public int getElm_id() {
		
		return this.elm_id;
	}
	
	public String getElm_name() {
		return this.elm_name;
	}
	
	public String getElm_module() {
		return this.elm_module;
	}
	
	public String getElm_annee() {
		return this.elm_annee;
	}
	
	public String getElm_semster() {
		return this.elm_semester;
	}
	
	public Date getDate_exam() {
		return this.date_exam;
	}
}
