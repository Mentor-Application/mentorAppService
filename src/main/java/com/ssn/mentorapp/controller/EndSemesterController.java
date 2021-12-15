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

import com.ssn.mentorapp.model.Endsemester;
import com.ssn.mentorapp.payload.request.EndSemesterRequest;
import com.ssn.mentorapp.service.EndSemesterService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/endsemester")
public class EndSemesterController {
	
	@Autowired
	private EndSemesterService endSemesterService;

	@PostMapping("/update")
	public ResponseEntity<?> setEndSemMarks(@RequestBody List<EndSemesterRequest> endSemesterRequests){
		List<Endsemester> endSem = new ArrayList<Endsemester>();
		for (int i = 0; i < endSemesterRequests.size(); i++) {
			endSem.add(endSemesterService.updateEndSemMarks(endSemesterRequests.get(i)));
		}
		return ResponseEntity.ok(endSem);
	}
	
	@GetMapping("/{studentId}/{semesterName}/list")
	public ResponseEntity<?> getEndSemMarks(@PathVariable("studentId") String studentId,@PathVariable("semesterName") String semesterName){
		List<Endsemester> marks = endSemesterService.getEndSemMarks(studentId, semesterName);
		return ResponseEntity.ok(marks);
	}
	
}
