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

import com.ssn.mentorapp.model.Additional;
import com.ssn.mentorapp.payload.request.AdditionalRequest;
import com.ssn.mentorapp.payload.response.MessageResponse;
import com.ssn.mentorapp.service.AdditionalService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/additional")
public class AdditionalController {
		@Autowired
		private AdditionalService additionalService;
		@PostMapping("/update")
		public ResponseEntity<?> updateDetails(@RequestBody AdditionalRequest additionalRequest)
		{
			Additional additional=additionalService.updateDetails(additionalRequest);
			return ResponseEntity.ok(additional);	
		}
		
		@GetMapping("/{studentId}/list")
		public ResponseEntity<?> getDetails(@PathVariable("studentId")String studentId)
		{
			Additional additional=additionalService.getDetails(studentId);
			if(additional != null) {
				return ResponseEntity.ok(additional);
			}
			else {
				return ResponseEntity.badRequest().body(new MessageResponse("student not found"));
			}
			
		}
}
