package com.ssn.mentorapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.payload.request.DisciplinaryRequest;
import com.ssn.mentorapp.repository.DisciplinaryRepository;

@Service
public class DisciplinaryService {

	@Autowired
	private DisciplinaryRepository disciplinaryRepository;
	
	public Disciplinary updateYearDetails(DisciplinaryRequest disciplinaryRequest)
	{
		
		Optional<Disciplinary> disciplinary=disciplinaryRepository.findByStudentId(disciplinaryRequest.getStudentId());
		
		if(disciplinary.isPresent())
		{
			disciplinary.get().setStudentId(disciplinaryRequest.getStudentId());
			disciplinary.get().setYear1(disciplinaryRequest.getYear1());
			disciplinary.get().setYear2(disciplinaryRequest.getYear2());
			disciplinary.get().setYear3(disciplinaryRequest.getYear3());
			disciplinary.get().setYear4(disciplinaryRequest.getYear4());
			return disciplinaryRepository.save(disciplinary.get());
		}
		else
		{
			Disciplinary disciplinarynew= new Disciplinary();
			disciplinarynew.setStudentId(disciplinaryRequest.getStudentId());
			disciplinarynew.setYear1(disciplinaryRequest.getYear1());
			disciplinarynew.setYear2(disciplinaryRequest.getYear2());
			disciplinarynew.setYear3(disciplinaryRequest.getYear3());
			disciplinarynew.setYear4(disciplinaryRequest.getYear4());
			return disciplinaryRepository.save(disciplinarynew);
		}
		
	}
	public Disciplinary getYearDetails(String studentId)
	{
		Disciplinary disciplinaryNew=disciplinaryRepository.findByStudentId(studentId).get();
		return disciplinaryNew;
	}
}
