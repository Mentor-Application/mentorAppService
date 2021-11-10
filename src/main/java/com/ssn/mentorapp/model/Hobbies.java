package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hobbies {
	
	@Id
	private String hobbieId;
	private String hobbie;
	
	public String getHobbieId() {
		return hobbieId;
	}
	
	public void setHobbieId(String hobbieId) {
		this.hobbieId = hobbieId;
	}
	
	public String getHobbie() {
		return hobbie;
	}
	
	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}

}
