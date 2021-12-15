package com.ssn.mentorapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.MentorMeeting;
import com.ssn.mentorapp.payload.request.MentorMeetingRequest;
import com.ssn.mentorapp.service.MentorMeetingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/mentormeeting")
public class MentorMeetingController {
	
	@Autowired
	private MentorMeetingService mentorMeetingService;

	
	@PostMapping("/update")
	public ResponseEntity<?> updateMeeting(@RequestBody List<MentorMeetingRequest> mentorMeetingRequests){
		List<MentorMeeting> meeting = new ArrayList<MentorMeeting>();
		for(int i=0;i<mentorMeetingRequests.size();i++) {
			meeting.add(mentorMeetingService.updateMeeting(mentorMeetingRequests.get(i)));
		}
		return ResponseEntity.ok(meeting);
	}
	
	@GetMapping("/{studentId}/{semesterName}/list")
	public ResponseEntity<?> getMeetingDetails(@PathVariable("studentId") String studentId,@PathVariable("semesterName") String semesterName){
		List<MentorMeeting> meetingList = mentorMeetingService.getMeetingDetails(studentId, semesterName);
		return ResponseEntity.ok(meetingList);
	}
}
