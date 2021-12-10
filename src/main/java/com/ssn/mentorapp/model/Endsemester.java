package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Endsemester {
	
	@Id
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
	
	private Float gpa;

	
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

	public Float getGpa() {
		return gpa;
	}

	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}

	public String getEndsemId() {
		return endsemId;
	}

	public void setEndsemId(String endsemId) {
		this.endsemId = endsemId;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradePoints() {
		return gradePoints;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
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

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	
	
	

}
