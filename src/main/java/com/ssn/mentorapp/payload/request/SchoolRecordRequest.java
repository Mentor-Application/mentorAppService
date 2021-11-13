package com.ssn.mentorapp.payload.request;

public class SchoolRecordRequest {
	
	private String studentId;

	private String course;
	private String yearPassedOut;
	private String nameOfSchool;
	private String board;
	private String percentage;
	private String twelfthCutOff;
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public String getTwelfthCutOff() {
		return twelfthCutOff;
	}

	public void setTwelfthCutOff(String twelfthCutOff) {
		this.twelfthCutOff = twelfthCutOff;
	} 
	
	

}
