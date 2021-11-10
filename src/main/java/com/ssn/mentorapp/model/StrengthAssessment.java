package com.ssn.mentorapp.model;

import java.util.Arrays;
import java.util.List;

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
	
	/*iAm;
	iCan : "",
	iHave : ""	 */
}
