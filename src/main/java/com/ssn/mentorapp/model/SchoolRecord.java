package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SchoolRecord {
	
	@Id
	private String schoolRecordId;
	private String course;
	private String yearPassedOut;
	private String nameOfSchool;
	private String board;
	private String percentage;
	
	public String getSchoolRecordId() {
		return schoolRecordId;
	}
	
	public void setSchoolRecordId(String schoolRecordId) {
		this.schoolRecordId = schoolRecordId;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getYearPassedOut() {
		return yearPassedOut;
	}
	
	public void setYearPassedOut(String yearPassedOut) {
		this.yearPassedOut = yearPassedOut;
	}
	
	public String getNameOfSchool() {
		return nameOfSchool;
	}
	
	public void setNameOfSchool(String nameOfSchool) {
		this.nameOfSchool = nameOfSchool;
	}
	
	public String getBoard() {
		return board;
	}
	
	public void setBoard(String board) {
		this.board = board;
	}
	
	public String getPercentage() {
		return percentage;
	}
	
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	} 
	
	

}
