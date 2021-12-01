package com.ssn.mentorapp.payload.request;

public class StudentSearchRequest {
	
	private String studentName;
	
	private String branch;
	
	private String periodOfStudy;
	
	private String section;
	
	


	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPeriodOfStudy() {
		return periodOfStudy;
	}

	public void setPeriodOfStudy(String periodOfStudy) {
		this.periodOfStudy = periodOfStudy;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	

}
