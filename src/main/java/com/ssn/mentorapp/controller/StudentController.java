package com.ssn.mentorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.Student;
import com.ssn.mentorapp.repository.StudentRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) 
	{
		return studentRepository.save(student);
	}
	
}
