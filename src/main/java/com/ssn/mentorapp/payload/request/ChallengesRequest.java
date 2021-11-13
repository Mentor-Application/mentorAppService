package com.ssn.mentorapp.payload.request;

public class ChallengesRequest {
	
	private String studentId;
	private String domain;
	private String challenges;
	private String sourceOfSupport;
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getChallenges() {
		return challenges;
	}
	
	public void setChallenges(String challenges) {
		this.challenges = challenges;
	}
	
	public String getSourceOfSupport() {
		return sourceOfSupport;
	}
	
	public void setSourceOfSupport(String sourceOfSupport) {
		this.sourceOfSupport = sourceOfSupport;
	}

}
