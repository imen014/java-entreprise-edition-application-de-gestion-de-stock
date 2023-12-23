package com.octest.beans;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String poste;
    private String status;
    private String role;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPoste() {
	return poste;
    }

    public void setPoste(String poste) {
	this.poste = poste;
    }

    public User(String username, String password, String email, String poste, String status, String role) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.poste = poste;
	this.status = status;
	this.role = role;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public User() {
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

}
