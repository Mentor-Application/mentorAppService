package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Challenges {
	
	@Id
	private String challengeId;
	private String domain;
	private String challenges;
	private String sourceOfSupport;
	
	public String getChallengeId() {
		return challengeId;
	}
	
	public void setChallengeId(String challengeId) {
		this.challengeId = challengeId;
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
