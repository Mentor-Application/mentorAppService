package com.ssn.mentorapp.payload.response;

import java.util.Date;
import java.util.List;

import com.ssn.mentorapp.model.Challenges;
import com.ssn.mentorapp.model.FamilyProfile;
import com.ssn.mentorapp.model.GoalsGrid;
import com.ssn.mentorapp.model.Hobbies;
import com.ssn.mentorapp.model.LocalGuardian;
import com.ssn.mentorapp.model.SchoolRecord;
import com.ssn.mentorapp.model.StrengthAssessment;

public class StudentResponse {
	
	private String studentId;
	private String registerNumber;
	private byte[] photo;
	private String studentName;
	private String mentorId;
	private String gender;
	private Date dob;
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
	private String personalEmail;
	
	
	
	private LocalGuardian localGuardian;
	
	private List<SchoolRecord> schoolRecord;
	
	private List<FamilyProfile> familyProfile;
	
	private List<Hobbies> hobbies;
	
	private List<GoalsGrid> goalsGrid;
	
	private List<Challenges> challenges;
	
	private StrengthAssessment strenghAssessment;
	
	

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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

	public LocalGuardian getLocalGuardian() {
		return localGuardian;
	}

	public void setLocalGuardian(LocalGuardian localGuardian) {
		this.localGuardian = localGuardian;
	}

	public List<SchoolRecord> getSchoolRecord() {
		return schoolRecord;
	}

	public void setSchoolRecord(List<SchoolRecord> schoolRecord) {
		this.schoolRecord = schoolRecord;
	}

	public List<FamilyProfile> getFamilyProfile() {
		return familyProfile;
	}

	public void setFamilyProfile(List<FamilyProfile> familyProfile) {
		this.familyProfile = familyProfile;
	}

	public List<Hobbies> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobbies> hobbies) {
		this.hobbies = hobbies;
	}

	public List<GoalsGrid> getGoalsGrid() {
		return goalsGrid;
	}

	public void setGoalsGrid(List<GoalsGrid> goalsGrid) {
		this.goalsGrid = goalsGrid;
	}

	public List<Challenges> getChallenges() {
		return challenges;
	}

	public void setChallenges(List<Challenges> challenges) {
		this.challenges = challenges;
	}

	public StrengthAssessment getStrenghAssessment() {
		return strenghAssessment;
	}

	public void setStrenghAssessment(StrengthAssessment strenghAssessment) {
		this.strenghAssessment = strenghAssessment;
	}
	
	

}
