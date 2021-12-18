package com.ssn.mentorapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Additional;
import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.payload.request.AdditionalRequest;
import com.ssn.mentorapp.payload.request.DisciplinaryRequest;
import com.ssn.mentorapp.repository.AdditionalRepository;

@Service
public class AdditionalService {
	@Autowired
	private AdditionalRepository additionalRepository;
	
	public Additional updateDetails(AdditionalRequest additionalRequest)
	{
		Optional<Additional> additional=additionalRepository.findByStudentId(additionalRequest.getStudentId());
		if(additional.isPresent())
		{
			additional.get().setStudentId(additionalRequest.getStudentId());
			additional.get().setPercentage(additionalRequest.getPercentage());
			additional.get().setClassName(additionalRequest.getClassName());
			additional.get().setRank(additionalRequest.getRank());
			additional.get().setGraduateStudy(additionalRequest.getGraduateStudy());
			additional.get().setCareerInfo(additionalRequest.getCareerInfo());
			return additionalRepository.save(additional.get());
		}
		else
		{
			Additional additionalnew=new Additional();
			additionalnew.setStudentId(additionalRequest.getStudentId());
			additionalnew.setPercentage(additionalRequest.getPercentage());
			additionalnew.setClassName(additionalRequest.getClassName());
			additionalnew.setRank(additionalRequest.getRank());
			additionalnew.setCareerInfo(additionalRequest.getCareerInfo());
			additionalnew.setGraduateStudy(additionalRequest.getGraduateStudy());
			return additionalRepository.save(additionalnew);

		}
		
	}
	public Additional getDetails(String studentId)
	{
		Additional aditionalNew=additionalRepository.findByStudentId(studentId).get();
		return aditionalNew ;
		
	}
	
}
