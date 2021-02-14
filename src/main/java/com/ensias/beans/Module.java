package com.ensias.beans;

import java.sql.Date;

public class Module {
	
	private int elm_id;
	private String elm_name;
	private String elm_module;
	private String elm_annee;
	private String elm_semester;
	private Date date_exam;
	
	
	public Module() {
		super();
	}
	
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
	
	public void setElm_id(int id) {
		this.elm_id = id;
	}
	
	public void setElm_name(String name) {
		this.elm_name = name;
	}
	
	public void setElm_module(String module) {
		this.elm_module = module;
	}
	
	public void setElm_annee(String annee) {
		this.elm_annee = annee;
	}
	
	public void setElm_semester(String semester) {
		this.elm_semester = semester;
	}
	public void setDate_exam(Date date) {
		this.date_exam = date;
	}
	
	
}
