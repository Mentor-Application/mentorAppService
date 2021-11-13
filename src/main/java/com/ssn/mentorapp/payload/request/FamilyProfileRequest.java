package com.ssn.mentorapp.payload.request;

public class FamilyProfileRequest {
	
	private String studentId;
	private String relationShip;
	private Integer age;
	private String educationalQualification;
	private String occupation;
	private Integer annualIncome;
	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	public String getRelationShip() {
		return relationShip;
	}
	
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getEducationalQualification() {
		return educationalQualification;
	}
	
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public Integer getAnnualIncome() {
		return annualIncome;
	}
	
	public void setAnnualIncome(Integer annualIncome) {
		this.annualIncome = annualIncome;
	}

}
