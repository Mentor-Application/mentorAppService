package com.ssn.mentorapp.payload.request;

public class LocalGuardianRequest {
	
	private	String guardianId;
	private	String guardianName;
	private	String address;
	private	String mobileNumber;
	private	String emailId;
	private String studentId;
	public String getGuardianId() {
		return guardianId;
	}
	public void setGuardianId(String guardianId) {
		this.guardianId = guardianId;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	

}
