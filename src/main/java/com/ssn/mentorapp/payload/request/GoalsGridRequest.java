package com.ssn.mentorapp.payload.request;

public class GoalsGridRequest {
	
	private String studentId;
	private String domain;
	private String goal;
	private String planOfAction;
	
	
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
