package com.ssn.mentorapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ssn.mentorapp.repository.ParentRepository;

@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	


}
