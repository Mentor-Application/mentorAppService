package com.ssn.mentorapp.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.model.Overall;
import com.ssn.mentorapp.payload.request.OverallRequest;
import com.ssn.mentorapp.repository.OverallRepository;

@Service
public class OverallService {
	
	@Autowired
	private OverallRepository overallRepository;
	
	public Overall updateYearDetails(OverallRequest overallRequest)
	{
		
		Optional<Overall> overall=overallRepository.findByStudentId(overallRequest.getStudentId());
		
		if(overall.isPresent())
		{
			overall.get().setStudentId(overallRequest.getStudentId());
			overall.get().setYear1(overallRequest.getYear1());
			overall.get().setYear2(overallRequest.getYear2());
			overall.get().setYear3(overallRequest.getYear3());
			overall.get().setYear4(overallRequest.getYear4());
			return overallRepository.save(overall.get());
		}
		else
		{
			Overall overallnew= new Overall();
			overallnew.setStudentId(overallRequest.getStudentId());
			overallnew.setYear1(overallRequest.getYear1());
			overallnew.setYear2(overallRequest.getYear2());
			overallnew.setYear3(overallRequest.getYear3());
			overallnew.setYear4(overallRequest.getYear4());
			return overallRepository.save(overallnew);
		}
		
	}
	public Overall getYearDetails(String studentId)
	{
		Overall overallNew=overallRepository.findByStudentId(studentId).get();
		return overallNew;
	}
}
