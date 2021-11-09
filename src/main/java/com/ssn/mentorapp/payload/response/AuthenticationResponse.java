package com.ssn.mentorapp.payload.response;

import java.util.List;

public class AuthenticationResponse {
	
	private String token;
	private String type = "Bearer";
	private String id;
	private String userName;
	private String email;
	private List<String> roles;
	
	
	
	public AuthenticationResponse(String token, String id, String userName, String email, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.userName = userName;
		this.roles = roles;
		this.email = email;
	}

	public String getAccessToken() {
		return token;
	}
	
	public void setAccessToken(String token) {
		this.token = token;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTokenType() {
		return type;
	}
	
	public void setTokenType(String type) {
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	

}
