package com.ssn.mentorapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.Subject;
import com.ssn.mentorapp.service.SemesterService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/semester")
public class SemesterController {
	
	@Autowired
	private SemesterService semesterService;
	
	@GetMapping("/subjects/{semesterName}")
	public ResponseEntity<?> getSubjects(@PathVariable("semesterName") String semesterName){
		List<Subject> subjects = semesterService.getSubjectesBySemester(semesterName);
		return ResponseEntity.ok(subjects);
	}

}
