package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Faculty {

	@Id
	private String facultyId;
	
	private String facultyName;
	
	private String FacultyEmail;

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getFacultyEmail() {
		return FacultyEmail;
	}

	public void setFacultyEmail(String facultyEmail) {
		FacultyEmail = facultyEmail;
	}
	
	
}
