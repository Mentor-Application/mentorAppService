package com.ssn.mentorapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.payload.request.ParentDetailRequest;
import com.ssn.mentorapp.repository.ParentRepository;

@Service
public class ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	
//	public Parent updateParentDetails(ParentDetailRequest parentDetailRequest) {
//
//	
//		Optional<Parent> parent = parentRepository.findByStudentId(parentDetailRequest.getStudentId());
//		if(parent.isPresent()) {
//			parent.get().setParentId(parentDetailRequest.getParentId());
//			parent.get().setParentName(parentDetailRequest.getParentName());
//			parent.get().setAddress(parentDetailRequest.getParentAddress());
//			parent.get().setEmailId(parentDetailRequest.getParentEmailId());
//			parent.get().setStudentId(parentDetailRequest.getStudentId());
//		}
//		parent.setParentId(parentDetailRequest.getParentId());
//		parent.setParentName(parentDetailRequest.getParentName());
//		parent.setAddress(parentDetailRequest.getParentAddress());
//		parent.setEmailId(parentDetailRequest.getParentEmailId());
//		parent.setStudentId(parentDetailRequest.getStudentId());
//	
//		
//		return parentRepository.save(parent);
//	}

}
