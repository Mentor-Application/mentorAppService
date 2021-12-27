package com.ssn.mentorapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import javax.mail.Multipart;

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
import org.springframework.web.multipart.MultipartFile;

import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.payload.request.ChallengesRequest;
import com.ssn.mentorapp.payload.request.FamilyProfileRequest;
import com.ssn.mentorapp.payload.request.GoalsGridRequest;
import com.ssn.mentorapp.payload.request.HobbiesRequest;
import com.ssn.mentorapp.payload.request.LocalGuardianRequest;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.payload.request.SchoolRecordRequest;
import com.ssn.mentorapp.payload.request.StrengthAssessmentRequest;
import com.ssn.mentorapp.payload.request.StudentDetailsRequest;
import com.ssn.mentorapp.payload.request.StudentSearchRequest;
import com.ssn.mentorapp.payload.response.MessageResponse;
import com.ssn.mentorapp.payload.response.StudentResponse;
import com.ssn.mentorapp.payload.response.StudentSearchResponse;
import com.ssn.mentorapp.repository.StudentRepository;
import com.ssn.mentorapp.service.ParentService;
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
	
	@PostMapping("/parent")
	public ResponseEntity<?> setParent(@RequestBody ParentDetailRequest parentDetailRequest){
		Student newStudent = studentService.updateParentProfile(parentDetailRequest);
		return ResponseEntity.ok(newStudent);
	}

	
	@PostMapping("/{studentId}/guardian")
	public ResponseEntity<?> setLocalGuardian(@RequestBody LocalGuardianRequest localGuardianRequest,@PathVariable("studentId") String studentId){
		Student newStudent = studentService.updateLocalGuardianDetails(localGuardianRequest,studentId);
		return ResponseEntity.ok(newStudent);
	}
	
	@GetMapping("/list/guardian/{studentId}")
	public ResponseEntity<?> getLoacalGuardian(@PathVariable("studentId")String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getLocalGuardian());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	@GetMapping("/list/parent/{studentId}")
	public ResponseEntity<?> getParent(@PathVariable("studentId")String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getParent());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	
	@GetMapping("/list/schoolrecord/{studentId}")
	public ResponseEntity<?> getSchoolRecord(@PathVariable("studentId") String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getSchoolRecord());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	
	@GetMapping("/list/familyProfile/{studentId}")
	public ResponseEntity<?> getFamilyProfile(@PathVariable("studentId") String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getFamilyProfile());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	
	@GetMapping("/list/hobbies/{studentId}")
	public ResponseEntity<?> getHobbies(@PathVariable("studentId") String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getHobbies());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	
	@GetMapping("/list/strengthassessment/{studentId}")
	public ResponseEntity<?> getStrengthAssessment(@PathVariable("studentId") String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getStrenghAssessment());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	
	@GetMapping("/list/goalsgrid/{studentId}")
	public ResponseEntity<?> getGoalsGrid(@PathVariable("studentId") String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getGoalsGrid());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	@PostMapping("/{studentId}/picture")
	public ResponseEntity<?> setProfilePic(@RequestParam("picture") MultipartFile picture,@PathVariable("studentId") String studentId){
		Student newStudent = studentRepository.findById(studentId).get();
		byte[] image;
		try {
			image = picture.getBytes();
			newStudent.setPhoto(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentRepository.save(newStudent);
		return ResponseEntity.ok(newStudent.getPhoto());
	}
	
	@GetMapping("/{studentId}/picture/list")
	public ResponseEntity<?> getProfilePic(@PathVariable("studentId") String studentId){
		Student newStudent = studentRepository.findById(studentId).get();
		return ResponseEntity.ok(newStudent.getPhoto());
	}
	
	@PostMapping("/{studentId}/schoolrecord")
	public ResponseEntity<?> setSchoolRecord(@RequestBody List<SchoolRecordRequest> schoolRecordRequest,@PathVariable("studentId") String studentId){
		Student newStudent = studentService.updateschoolRecordDetails(schoolRecordRequest,studentId);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/{studentId}/familyprofile")
	public ResponseEntity<?> setFamilyProfile(@RequestBody List<FamilyProfileRequest> familyProfileRequest,@PathVariable("studentId") String studentId){
		Student newStudent = studentService.updatefamilyProfileDetails(familyProfileRequest,studentId);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/{studentId}/hobbies")
	public ResponseEntity<?> setHobbies(@RequestBody List<HobbiesRequest> hobbiesRequest,@PathVariable("studentId") String studentId){
		Student newStudent = studentService.updatehobbies(hobbiesRequest,studentId);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/{studentId}/strengthassessment")
	public ResponseEntity<?> setStrengthAssessment(@RequestBody StrengthAssessmentRequest strengthAssessmentRequest,@PathVariable("studentId") String studentId){
		Student newStudent = studentService.updatestrengthAssessment(strengthAssessmentRequest,studentId);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/{studentId}/goalsgrid")
	public ResponseEntity<?> setGoalsGrid(@RequestBody List<GoalsGridRequest> goalsGridRequest,@PathVariable("studentId") String studentId){
		Student newStudent = studentService.updategoalsGrid(goalsGridRequest,studentId);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/{studentId}/challenges")
	public ResponseEntity<?> setChallenges(@RequestBody List<ChallengesRequest> challengesRequest,@PathVariable("studentId") String studentId){
		Student newStudent = studentService.updatechallenges(challengesRequest,studentId);
		return ResponseEntity.ok(newStudent);
	}
	
	
	@GetMapping("/list/challenges/{studentId}")
	public ResponseEntity<?> getChallenges(@PathVariable("studentId") String studentId){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent.getChallenges());
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	@GetMapping("/{studentId}/profile")
	public ResponseEntity<?> getStudentById(@PathVariable("studentId") String studentId ){
		Student existingStudent = studentRepository.findById(studentId).get();
		if(existingStudent != null) {
			return ResponseEntity.ok(existingStudent);
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
		}
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchStudent(@RequestParam String periodOfStudy,
											@RequestParam String studentName,
											@RequestParam String branch,
											@RequestParam String section){
		StudentSearchRequest studentSearchRequest = new StudentSearchRequest();
		studentSearchRequest.setBranch(branch);
		studentSearchRequest.setPeriodOfStudy(periodOfStudy);
		studentSearchRequest.setSection(section);
		studentSearchRequest.setStudentName(studentName);
		List<StudentSearchResponse> students = studentService.searchStudent(studentSearchRequest,0,10);
		return ResponseEntity.ok(students); 
	}
	
	@GetMapping("/faculty/search")
	public ResponseEntity<?> searchStudentForFaculty(@RequestParam String periodOfStudy,
											@RequestParam String studentName,
											@RequestParam String branch,
											@RequestParam String section){
		StudentSearchRequest studentSearchRequest = new StudentSearchRequest();
		studentSearchRequest.setBranch(branch);
		studentSearchRequest.setPeriodOfStudy(periodOfStudy);
		studentSearchRequest.setSection(section);
		studentSearchRequest.setStudentName(studentName);
		List<StudentSearchResponse> students = studentService.searchStudentForFaculty(studentSearchRequest,0,10);
		return ResponseEntity.ok(students); 
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
	
	@PostMapping("/mentor/{mentorId}/addmentee")
	public ResponseEntity<?> setMentorIdforStudents(@RequestBody List<StudentSearchRequest> studentSearchRequest,@PathVariable ("mentorId") String mentorId ){
		
		studentService.setMentorIdforStudents(studentSearchRequest, mentorId);
		
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/mentor/{mentorId}/editmentee")
	public ResponseEntity<?> setMentorIdNullforStudents(@RequestBody List<StudentSearchRequest> studentSearchRequest){
		
		studentService.setMentorIdNullforStudents(studentSearchRequest);
		
		return ResponseEntity.ok(null);
	}
	
}
