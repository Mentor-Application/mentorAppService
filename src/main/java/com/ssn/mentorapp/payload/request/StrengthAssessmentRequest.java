package com.ssn.mentorapp.payload.request;

public class StrengthAssessmentRequest {
	
	private String studentId;

	private String iAm;
	private String iCan;
	private String iHave;
	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
