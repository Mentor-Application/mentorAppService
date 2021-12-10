package com.ssn.mentorapp.payload.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class MentorMeetingRequest {
	
private String meetingId;
	
	private String studentId;
	
	private String semesterName;

	private String meetingDate;
	
	private String meetingTime;
	
	private String focusOnDiscussion;
	
	private String remarks;

	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	

	public String getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	public String getFocusOnDiscussion() {
		return focusOnDiscussion;
	}

	public void setFocusOnDiscussion(String focusOnDiscussion) {
		this.focusOnDiscussion = focusOnDiscussion;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
