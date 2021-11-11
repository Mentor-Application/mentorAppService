package com.ssn.mentorapp.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StrengthAssessment {

	@Id
	private String strengthAssesmentId;
	private String iAm;
	private String iCan;
	private String iHave;
	
	
	public String getStrengthAssesmentId() {
		return strengthAssesmentId;
	}

	public void setStrengthAssesmentId(String strengthAssesmentId) {
		this.strengthAssesmentId = strengthAssesmentId;
	}

	public String getiAm() {
		return iAm;
	}

	public void setiAm(String iAm) {
		this.iAm = iAm;
	}

	public String getiCan() {
		return iCan;
	}

	public void setiCan(String iCan) {
		this.iCan = iCan;
	}

	public String getiHave() {
		return iHave;
	}

	public void setiHave(String iHave) {
		this.iHave = iHave;
	}
	
	
}
