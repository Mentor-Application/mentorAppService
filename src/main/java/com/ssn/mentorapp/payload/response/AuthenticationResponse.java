package com.ssn.mentorapp.payload.response;

import java.util.List;

import org.springframework.http.HttpStatus;

public class AuthenticationResponse {
	
	private String token;
	private String type = "Bearer";
	private String id;
	private String userName;
	private String email;
	private String studentId;
	private String mentorId;
	private String parentId;
	private String facultyId;
	private List<String> roles;
	private HttpStatus status;
	
	
	public AuthenticationResponse(String token, String id, String userName, String email,String studentId,String mentorId,String parentId,String facutyId, List<String> roles,HttpStatus status) {
		super();
		this.token = token;
		this.id = id;
		this.userName = userName;
		this.roles = roles;
		this.email = email;
		this.studentId = studentId;
		this.parentId = parentId;
		this.mentorId = mentorId;
		this.facultyId = facutyId;
		this.status = status;
	}

	public String getAccessToken() {
		return token;
	}
	
	public void setAccessToken(String token) {
		this.token = token;
	}
	
	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getMentorId() {
		return mentorId;
	}

	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
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

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}
