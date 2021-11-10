package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LocalGuardian {
	
	@Id
	private	String guardianId;
	private	String guardianName;
	private	String address;
	private	String mobileNumber;
	private	String emailId;
	
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
	

}
