package com.ssn.mentorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.payload.request.DisciplinaryRequest;
import com.ssn.mentorapp.service.DisciplinaryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/disciplinary")
public class DisciplinaryController {
	
	@Autowired
	private DisciplinaryService disciplinaryService;
	
	@PostMapping("/update")
	public ResponseEntity<?> setYearDetails(@RequestBody DisciplinaryRequest disciplinaryRequest)
	{
		
		Disciplinary disciplinary = disciplinaryService.updateYearDetails(disciplinaryRequest);
		return ResponseEntity.ok(disciplinary);
	}
	@GetMapping("/{studentId}/list")
	public ResponseEntity<?> getYearDetails(@PathVariable("studentId") String studentId)
	{
		Disciplinary disciplinary=disciplinaryService.getYearDetails(studentId);
		return ResponseEntity.ok(disciplinary);
	}
	
}
