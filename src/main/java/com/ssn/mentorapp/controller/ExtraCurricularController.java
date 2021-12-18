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
import com.ssn.mentorapp.model.ExtraCurricular;
import com.ssn.mentorapp.payload.request.DisciplinaryRequest;
import com.ssn.mentorapp.payload.request.ExtraCurricularRequest;
import com.ssn.mentorapp.service.DisciplinaryService;
import com.ssn.mentorapp.service.ExtraCurricularService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/extracurricular")
public class ExtraCurricularController {
	@Autowired
	private ExtraCurricularService extraCurricularService;
	@PostMapping("/update")
	public ResponseEntity<?> setYearDetails(@RequestBody ExtraCurricularRequest extraCurricularRequest)
	{
		
		ExtraCurricular extraCurricular = extraCurricularService.updateYearDetails(extraCurricularRequest);
		return ResponseEntity.ok(extraCurricular);
	}
	@GetMapping("/{studentId}/list")
	public ResponseEntity<?> getYearDetails(@PathVariable("studentId")String studentId)
	{
		ExtraCurricular extraCurricular=extraCurricularService.getYearDetails(studentId);
		return ResponseEntity.ok(extraCurricular);
	}
}
