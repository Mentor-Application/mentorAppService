package com.ssn.mentorapp.payload.request;

public class ImageRequest {

	
	private byte[] image;
	
	private String studentId;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
}
