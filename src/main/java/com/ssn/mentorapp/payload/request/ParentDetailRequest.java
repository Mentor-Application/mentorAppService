package com.ssn.mentorapp.payload.request;

public class ParentDetailRequest {
	
	private String studentId;
	private String parentId;
	private String parentName;
	private String parentAddress;
	private String parentEmailId;
	
	public String getParentId() {
		return parentId;
	}
	public String getParentAddress() {
		return parentAddress;
	}
	public void setParentAddress(String parentAddress) {
		this.parentAddress = parentAddress;
	}
	public String getParentEmailId() {
		return parentEmailId;
	}
	public void setParentEmailId(String parentEmailId) {
		this.parentEmailId = parentEmailId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	

}
