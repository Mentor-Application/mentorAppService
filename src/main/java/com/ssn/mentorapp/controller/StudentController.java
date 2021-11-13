package com.ssn.mentorapp.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.payload.request.ChallengesRequest;
import com.ssn.mentorapp.payload.request.FamilyProfileRequest;
import com.ssn.mentorapp.payload.request.GoalsGridRequest;
import com.ssn.mentorapp.payload.request.HobbiesRequest;
import com.ssn.mentorapp.payload.request.LocalGuardianRequest;

import com.ssn.mentorapp.payload.request.SchoolRecordRequest;
import com.ssn.mentorapp.payload.request.StrengthAssessmentRequest;
import com.ssn.mentorapp.payload.request.StudentDetailsRequest;
import com.ssn.mentorapp.payload.response.MessageResponse;
import com.ssn.mentorapp.payload.response.StudentResponse;
import com.ssn.mentorapp.repository.StudentRepository;
import com.ssn.mentorapp.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/profile")
	public ResponseEntity<?> setStudentProfile(@RequestBody StudentDetailsRequest studentDetailsRequest) throws ParseException{
		Student newStudent = studentService.updateStudentProfile(studentDetailsRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	
	@PostMapping("/guardian")
	public ResponseEntity<?> setLocalGuardian(@RequestBody LocalGuardianRequest localGuardianRequest){
		Student newStudent = studentService.updateLocalGuardianDetails(localGuardianRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/schoolrecord")
	public ResponseEntity<?> setSchoolRecord(@RequestBody List<SchoolRecordRequest> schoolRecordRequest){
		Student newStudent = studentService.updateschoolRecordDetails(schoolRecordRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/familyprofile")
	public ResponseEntity<?> setFamilyProfile(@RequestBody List<FamilyProfileRequest> familyProfileRequest){
		Student newStudent = studentService.updatefamilyProfileDetails(familyProfileRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/hobbies")
	public ResponseEntity<?> setHobbies(@RequestBody List<HobbiesRequest> hobbiesRequest){
		Student newStudent = studentService.updatehobbies(hobbiesRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/strengthassessment")
	public ResponseEntity<?> setStrengthAssessment(@RequestBody StrengthAssessmentRequest strengthAssessmentRequest){
		Student newStudent = studentService.updatestrengthAssessment(strengthAssessmentRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/goalsgrid")
	public ResponseEntity<?> setGoalsGrid(@RequestBody List<GoalsGridRequest> goalsGridRequest){
		Student newStudent = studentService.updategoalsGrid(goalsGridRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/challenges")
	public ResponseEntity<?> setChallenges(@RequestBody List<ChallengesRequest> challengesRequest){
		Student newStudent = studentService.updatechallenges(challengesRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentById(@PathVariable("studentId") String studentId ){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent);
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	
	@GetMapping("/mentor/{mentorId}")
	public ResponseEntity<?> getStudentsByMentorId(@PathVariable("mentorId") String mentorId){
		List<StudentResponse> studentResponse = studentService.getStudentByMentorId(mentorId);
		if(studentResponse != null) {
			return ResponseEntity.ok(studentResponse);
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("students not found"));
		}
	}
}
