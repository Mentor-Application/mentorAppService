package com.ssn.mentorapp.payload.request;

public class HobbiesRequest {
	
	private String studentId;
	private String hobbieId;
	private String hobbie;
	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getHobbieId() {
		return hobbieId;
	}
	
	public void setHobbieId(String hobbieId) {
		this.hobbieId = hobbieId;
	}
	
	public String getHobbie() {
		return hobbie;
	}
	
	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}

}
