package com.ssn.mentorapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.model.ExtraCurricular;
import com.ssn.mentorapp.payload.request.DisciplinaryRequest;
import com.ssn.mentorapp.payload.request.ExtraCurricularRequest;
import com.ssn.mentorapp.repository.ExtraCurricularRepository;

@Service
public class ExtraCurricularService {
	
	@Autowired
	private  ExtraCurricularRepository extraCurricularRepository;
	public ExtraCurricular updateYearDetails(ExtraCurricularRequest extraCurricularRequest)
	{
		
		Optional<ExtraCurricular> extraCurricular=extraCurricularRepository.findByStudentId(extraCurricularRequest.getStudentId());
		
		if(extraCurricular.isPresent())
		{
			extraCurricular.get().setStudentId(extraCurricularRequest.getStudentId());
			extraCurricular.get().setYear1(extraCurricularRequest.getYear1());
			extraCurricular.get().setYear2(extraCurricularRequest.getYear2());
			extraCurricular.get().setYear3(extraCurricularRequest.getYear3());
			extraCurricular.get().setYear4(extraCurricularRequest.getYear4());
			return extraCurricularRepository.save(extraCurricular.get());
		}
		else
		{
			ExtraCurricular extraCurricular2= new ExtraCurricular();
			extraCurricular2.setStudentId(extraCurricularRequest.getStudentId());
			extraCurricular2.setYear1(extraCurricularRequest.getYear1());
			extraCurricular2.setYear2(extraCurricularRequest.getYear2());
			extraCurricular2.setYear3(extraCurricularRequest.getYear3());
			extraCurricular2.setYear4(extraCurricularRequest.getYear4());
			return extraCurricularRepository.save(extraCurricular2);
		}	
	}
	public ExtraCurricular getYearDetails(String studentId)
	{
		ExtraCurricular extraCurricularnew=extraCurricularRepository.findByStudentId(studentId).get();
		return extraCurricularnew;
	}

}
