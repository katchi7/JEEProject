package com.ensias.beans;

public class Document {
	 private int      doc_id; 
	 private String   doc_name;
	 private String   doc_path; 
	 private String   doc_type; 
	 private String   doc_mime; 
	 private int      doc_elm; 
	 
	 public int getDoc_id() {
		 
		return this.doc_id;
	 }
	 public String getDoc_name() {
		 return this.doc_name;
	 }
	 
	 public String getDoc_path() {
		 return this.doc_path;
	 }
	 public String getDoc_type() {
		 return this.doc_type;
	 }
	 public String getDoc_mime() {
		 return this.doc_mime;
	 }
	 
	 public int getDoc_elm() {
		 return this.doc_elm;
	 }
	 
	 public void setDoc_id(int id) {
		 this.doc_id = id;
	 }
	 
	 public void setDoc_name( String name ) {
		 this.doc_name=name;
	 }
	 public void setDoc_path(String path) {
		 this.doc_path = path;
	 }
	 
	 public void setDoc_type(String type) {
		 this.doc_type = type;
	 }
	 
	 public void setDoc_mime(String mime) {
		 this.doc_mime = mime;
	 }
	 public void setDoc_elm(int elm) {
		 this.doc_elm = elm;
	 }
	 
	 
	 
	 
}
