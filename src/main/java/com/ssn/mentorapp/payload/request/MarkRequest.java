package com.ssn.mentorapp.payload.request;

public class MarkRequest {
	
    private String markId;
		
	private String semesterName;
	
	private String studentId;
	
	private String subjectCode;
	
	private String subjectName;
	
	private Long  firstCatMark;
	
	private Long secondCatMark;
	
	private Long thirdCatMark;
	
	private Long internalMark;
	
	private Long attendance;
	

	public String getMarkId() {
		return markId;
	}

	public void setMarkId(String markId) {
		this.markId = markId;
	}


	

	public Long getAttendance() {
		return attendance;
	}

	public void setAttendance(Long attendance) {
		this.attendance = attendance;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public Long getFirstCatMark() {
		return firstCatMark;
	}

	public void setFirstCatMark(Long firstCatMark) {
		this.firstCatMark = firstCatMark;
	}

	public Long getSecondCatMark() {
		return secondCatMark;
	}

	public void setSecondCatMark(Long secondCatMark) {
		this.secondCatMark = secondCatMark;
	}

	public Long getThirdCatMark() {
		return thirdCatMark;
	}

	public void setThirdCatMark(Long thirdCatMark) {
		this.thirdCatMark = thirdCatMark;
	}

	public Long getInternalMark() {
		return internalMark;
	}

	public void setInternalMark(Long internalMark) {
		this.internalMark = internalMark;
	}


}
