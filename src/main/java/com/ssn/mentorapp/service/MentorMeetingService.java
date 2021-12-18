package com.ssn.mentorapp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.MentorMeeting;
import com.ssn.mentorapp.payload.request.MentorMeetingRequest;
import com.ssn.mentorapp.repository.MentorMeetingRepository;

@Service
public class MentorMeetingService {
	
	@Autowired
	private MentorMeetingRepository meetingRepository;
	
	
	
	public MentorMeeting updateMeeting(MentorMeetingRequest mentorMeetingRequest) {
		Optional<MentorMeeting> meeting = meetingRepository.findByStudentIdAndSemesterNameAndFocusOnDiscussion(mentorMeetingRequest.getStudentId(), 
																									 mentorMeetingRequest.getSemesterName(), 
																								 mentorMeetingRequest.getFocusOnDiscussion());
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if(meeting.isPresent()) {
			meeting.get().setFocusOnDiscussion(mentorMeetingRequest.getFocusOnDiscussion());
			meeting.get().setMeetingDate(LocalDate.parse(mentorMeetingRequest.getMeetingDate(),format));
			meeting.get().setMeetingId(mentorMeetingRequest.getMeetingId());
			meeting.get().setMeetingTime(mentorMeetingRequest.getMeetingTime());
			meeting.get().setRemarks(mentorMeetingRequest.getRemarks());
			meeting.get().setSemesterName(mentorMeetingRequest.getSemesterName());
			meeting.get().setStudentId(mentorMeetingRequest.getStudentId());
			return meetingRepository.save(meeting.get());
		}
		else {
			MentorMeeting newMeet = new MentorMeeting();
			newMeet.setFocusOnDiscussion(mentorMeetingRequest.getFocusOnDiscussion());
			newMeet.setMeetingDate(LocalDate.parse(mentorMeetingRequest.getMeetingDate(),format));
			newMeet.setMeetingId(mentorMeetingRequest.getMeetingId());
			newMeet.setMeetingTime(mentorMeetingRequest.getMeetingTime());
			newMeet.setRemarks(mentorMeetingRequest.getRemarks());
			newMeet.setSemesterName(mentorMeetingRequest.getSemesterName());
			newMeet.setStudentId(mentorMeetingRequest.getStudentId());
			return meetingRepository.save(newMeet);
		}
	}
	
	
	public List<MentorMeeting> getMeetingDetails(String studentId,String SemesterName){
		List<MentorMeeting> meetingList = meetingRepository.findAllByStudentIdAndSemesterName(studentId, SemesterName);
		return meetingList;
	}

	
	
}
