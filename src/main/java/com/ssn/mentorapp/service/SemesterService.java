package com.ssn.mentorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Semester;
import com.ssn.mentorapp.model.Subject;
import com.ssn.mentorapp.repository.SemesterRespository;

@Service
public class SemesterService {
	
	@Autowired
	private SemesterRespository semseRespository;
	
	public List<Subject> getSubjectesBySemester(String semesterName) {
		Semester existingSemester = semseRespository.findBySemesterName(semesterName).get();
		return existingSemester.getSubjects();
		
	}

}
