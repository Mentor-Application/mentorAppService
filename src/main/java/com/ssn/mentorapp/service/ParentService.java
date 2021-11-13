package com.ssn.mentorapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.repository.ParentRepository;

@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	
	public Parent updateParentDetails(ParentDetailRequest parentDetailRequest) {

	
		Parent parent = parentRepository.findByEmailId(parentDetailRequest.getEmailId()).get();
		parent.setParentId(parentDetailRequest.getParentId());
		parent.setParentName(parentDetailRequest.getParentName());
		parent.setAddress(parentDetailRequest.getAddress());
		parent.setEmailId(parentDetailRequest.getEmailId());
		parent.setStudentId(parentDetailRequest.getStudentId());
	
		
		return parentRepository.save(parent);
	}

}
