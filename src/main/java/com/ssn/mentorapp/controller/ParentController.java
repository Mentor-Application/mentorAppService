package com.ssn.mentorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.service.ParentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parent")
public class ParentController {
	
	@Autowired
	private ParentService parentService;
	
	@PostMapping("/create")
	public ResponseEntity<?> setParentDetails(@RequestBody ParentDetailRequest parentDetailRequest){
		Parent newParent = parentService.updateParentDetails(parentDetailRequest);
		return ResponseEntity.ok(newParent);
	}

}
