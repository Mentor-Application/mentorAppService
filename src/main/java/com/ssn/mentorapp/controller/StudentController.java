package com.ssn.mentorapp.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.payload.request.LocalGuardianRequest;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.payload.request.StudentDetailsRequest;
import com.ssn.mentorapp.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/profile")
	public ResponseEntity<?> setStudentProfile(@RequestBody StudentDetailsRequest studentDetailsRequest) throws ParseException{
		Student newStudent = studentService.updateStudentProfile(studentDetailsRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/parent")
	public ResponseEntity<?> setParentDetails(@RequestBody ParentDetailRequest parentDetailRequest){
		Student newStudent = studentService.updateParentDetails(parentDetailRequest);
		return ResponseEntity.ok(newStudent);
	}
	
	@PostMapping("/guardian")
	public ResponseEntity<?> setLocalGuardian(@RequestBody LocalGuardianRequest localGuardianRequest){
		Student newStudent = studentService.updateLocalGuardianDetails(localGuardianRequest);
		return ResponseEntity.ok(newStudent);
	}
	
}
