package com.ssn.mentorapp.payload.request;

import java.util.Set;

import com.mongodb.lang.NonNull;

public class SignUpRequest {
	
	private String userName;
	
	@NonNull
	private String email;
	
	@NonNull
	private String password;
	
	private String studentEmail;
	
	private Set<String> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	

}
