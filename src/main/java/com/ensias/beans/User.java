package com.ensias.beans;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class User {
	private int id ;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private boolean administrator;
    private String num;
    private String niveau;
    private String filiere;
    private String full_filiere;
    
   
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getLname() {
        return lname;
    }

    public String getFname() {
        return fname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFiliere() {
        return filiere;
    }
    public String getFull_filiere() {
        return this.full_filiere;
    }


    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public void setFull_filiere(String filiere) {
        this.full_filiere = filiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public String  getPasswordAsHash() {
    	return Hashing.sha256().hashString(this.password, StandardCharsets.UTF_8).toString();
    }
    public boolean isAdministrator() {
    	return this.administrator;
    }
    public void setAdministrator(boolean admin) {
    	this.administrator = admin;
    }
}
