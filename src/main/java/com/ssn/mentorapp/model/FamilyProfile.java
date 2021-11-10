package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FamilyProfile {
	
	@Id
	private String familyProfileId;
	private String relationShip;
	private Integer age;
	private String educationalQualification;
	private String occupation;
	private Integer annualIncome;
	
	public String getFamilyProfileId() {
		return familyProfileId;
	}
	
	public void setFamilyProfileId(String familyProfileId) {
		this.familyProfileId = familyProfileId;
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
