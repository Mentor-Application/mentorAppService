package com.ssn.mentorapp.payload.request;


public class EndSemesterRequest {
	
private String endsemId;
	
	private String semesterName;
	
	private String subjectCode;
	
	private String subjectName;
	
	private String studentId;
	
	private String grade;
	
	private String gradePoints;
	
	private String monthAndYearOfPassing;

	private String credits;
	
	private String totalGradePoints;
	
	private String gpa;
	
	private String attempt1;
	
	private String attempt2;

	public String getEndsemId() {
		return endsemId;
	}

	public void setEndsemId(String endsemId) {
		this.endsemId = endsemId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradePoints() {
		return gradePoints;
	}

	public void setGradePoints(String gradePoints) {
		this.gradePoints = gradePoints;
	}

	public String getMonthAndYearOfPassing() {
		return monthAndYearOfPassing;
	}

	public void setMonthAndYearOfPassing(String monthAndYearOfPassing) {
		this.monthAndYearOfPassing = monthAndYearOfPassing;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getTotalGradePoints() {
		return totalGradePoints;
	}

	public void setTotalGradePoints(String totalGradePoints) {
		this.totalGradePoints = totalGradePoints;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getAttempt1() {
		return attempt1;
	}

	public void setAttempt1(String attempt1) {
		this.attempt1 = attempt1;
	}

	public String getAttempt2() {
		return attempt2;
	}

	public void setAttempt2(String attempt2) {
		this.attempt2 = attempt2;
	}
	

}
