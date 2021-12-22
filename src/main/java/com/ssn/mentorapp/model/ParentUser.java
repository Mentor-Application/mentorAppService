package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("parent")
public class ParentUser {

	@Id
	private String parentId;
	
	
	private String studentId ;
	
	private String studentEmail;
	
	private String emailId;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String email) {
		this.emailId = email;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	
}
