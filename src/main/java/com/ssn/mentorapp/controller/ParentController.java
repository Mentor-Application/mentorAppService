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

import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.model.ParentUser;
import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.payload.response.MessageResponse;
import com.ssn.mentorapp.repository.ParentRepository;
import com.ssn.mentorapp.repository.StudentRepository;
import com.ssn.mentorapp.service.ParentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parent")
public class ParentController {
	
	
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
//	@PostMapping("/create")
//	public ResponseEntity<?> setParentDetails(@RequestBody ParentDetailRequest parentDetailRequest){
//		Parent newParent = parentService.updateParentDetails(parentDetailRequest);
//		return ResponseEntity.ok(newParent);
//	}
	
//	@GetMapping("/{studentId}")
//	public ResponseEntity<?> getParent(@PathVariable("studentId") String studentId){
//		Parent existingParent = parentRepository.findByStudentId(studentId).get();
//		return ResponseEntity.ok(existingParent);
//	}
	
	public ResponseEntity<?> getStudentByParentId(@PathVariable("parentId") String parentId){
		ParentUser existingParent = parentRepository.findById(parentId).get();
		Student existingStudent = studentRepository.findById(existingParent.getStudentId()).get();
		if(existingStudent == null) {
			return ResponseEntity.badRequest().body((new MessageResponse("student not found")));
		}
		else {
			return ResponseEntity.ok(existingStudent);
		}
	}
}
