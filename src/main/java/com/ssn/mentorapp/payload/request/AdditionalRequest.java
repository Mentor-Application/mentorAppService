package com.ssn.mentorapp.payload.request;

public class AdditionalRequest {
	private String studentId;
	private String percentage;
	private String className;
	private String rank;
	private String graduateStudy;
	private String careerInfo;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getGraduateStudy() {
		return graduateStudy;
	}
	public void setGraduateStudy(String graduateStudy) {
		this.graduateStudy = graduateStudy;
	}
	public String getCareerInfo() {
		return careerInfo;
	}
	public void setCareerInfo(String careerInfo) {
		this.careerInfo = careerInfo;
	}
}
