package com.ssn.mentorapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.Marks;
import com.ssn.mentorapp.payload.request.MarkRequest;
import com.ssn.mentorapp.payload.response.MarkResponse;
import com.ssn.mentorapp.service.MarkService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/marks")
public class MarkController {

	@Autowired
	private MarkService markService;

	@PostMapping("/update")
	public ResponseEntity<?> updateMarks(@RequestBody List<MarkRequest> markRequests) {
		List<Marks> marks = new ArrayList<Marks>();
		for (int i = 0; i < markRequests.size(); i++) {
			marks.add(markService.updateMark(markRequests.get(i)));
		}
		return ResponseEntity.ok(marks);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getMarks(@RequestBody List<MarkRequest> markRequests){
		List<MarkResponse> marks = markService.getMarks(markRequests);
		return ResponseEntity.ok(marks);
	}

}
