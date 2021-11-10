package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	
	@Id
	private String studentId;
	private String studentName;
	private String mentorId;
	private String gender;
	private String dob;
	private String branch;
	private String section;
	private String mobileNumber;	
	private String fatherMobileNumber;
	private String motherMobileNumber;
	private String religion;
	private String community;
	private String bloodGroup;
	private String studentType;
	private String addressForCommunication;
	private String periodOfStudy;
	private String emailId;
	private Integer roomNumber;
	private Integer busRouteNumber;
	
	private Parent parent;
	
	private LocalGuardian localGuardian;
	
	private SchoolRecord schoolRecord;
	
	private FamilyProfile familyProfile;
	
	private Hobbies hobbies;
	
	private GoalsGrid goalsGrid;
	
	private Challenges challenges;
	
	private StrengthAssessment strenghAssessment;
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMentorId() {
		return mentorId;
	}

	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}

	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}

	public String getMotherMobileNumber() {
		return motherMobileNumber;
	}

	public void setMotherMobileNumber(String motherMobileNumber) {
		this.motherMobileNumber = motherMobileNumber;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getAddressForCommunication() {
		return addressForCommunication;
	}

	public void setAddressForCommunication(String addressForCommunication) {
		this.addressForCommunication = addressForCommunication;
	}

	public String getPeriodOfStudy() {
		return periodOfStudy;
	}

	public void setPeriodOfStudy(String periodOfStudy) {
		this.periodOfStudy = periodOfStudy;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getBusRouteNumber() {
		return busRouteNumber;
	}

	public void setBusRouteNumber(Integer busRouteNumber) {
		this.busRouteNumber = busRouteNumber;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	

}
