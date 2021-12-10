package com.ssn.mentorapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.MentorMeeting;

@Repository
public interface MentorMeetingRepository extends MongoRepository<MentorMeeting, String> {

	
	Optional<MentorMeeting> findByStudentIdAndSemesterNameAndFocusOnDiscussion(String studentId,String semesterName,String focusOnDiscussion);
	
	List<MentorMeeting> findAllByStudentIdAndSemesterName(String studentId,String semesterName);
}
