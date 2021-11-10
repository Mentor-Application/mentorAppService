package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GoalsGrid {
	
	@Id
	private String goalId;
	private String domain;
	private String goal;
	private String planOfAction;
	
	public String getGoalId() {
		return goalId;
	}
	
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getGoal() {
		return goal;
	}
	
	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	public String getPlanOfAction() {
		return planOfAction;
	}
	
	public void setPlanOfAction(String planOfAction) {
		this.planOfAction = planOfAction;
	}

	
}
