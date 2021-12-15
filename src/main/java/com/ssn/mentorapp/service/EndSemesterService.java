package com.ssn.mentorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.mentorapp.model.Endsemester;
import com.ssn.mentorapp.payload.request.EndSemesterRequest;
import com.ssn.mentorapp.repository.EndSemesterRespository;

@Service
public class EndSemesterService {
	
	
	@Autowired
	private EndSemesterRespository endSemesterRespository;
	
	
	public Endsemester updateEndSemMarks(EndSemesterRequest endSemesterRequest) {
		Optional<Endsemester> endsem = endSemesterRespository.findBySemesterNameAndStudentIdAndSubjectCode(endSemesterRequest.getSemesterName(),
																										   endSemesterRequest.getStudentId(), 
																										   endSemesterRequest.getSubjectCode());
		if(endsem.isPresent()) {
			endsem.get().setEndsemId(endSemesterRequest.getEndsemId());
			endsem.get().setGrade(endSemesterRequest.getGrade());
			endsem.get().setGradePoints(endSemesterRequest.getGradePoints());
			endsem.get().setMonthAndYearOfPassing(endSemesterRequest.getMonthAndYearOfPassing());
			endsem.get().setSemesterName(endSemesterRequest.getSemesterName());
			endsem.get().setStudentId(endSemesterRequest.getStudentId());
			endsem.get().setSubjectCode(endSemesterRequest.getSubjectCode());
			endsem.get().setSubjectName(endSemesterRequest.getSubjectName());
			endsem.get().setCredits(endSemesterRequest.getCredits());
			endsem.get().setGpa(endSemesterRequest.getGpa());
			endsem.get().setTotalGradePoints(endSemesterRequest.getTotalGradePoints());
			return endSemesterRespository.save(endsem.get());
		}
		else {
			Endsemester endsemnew = new Endsemester();
			endsemnew.setEndsemId(endSemesterRequest.getEndsemId());
			endsemnew.setGrade(endSemesterRequest.getGrade());
			endsemnew.setGradePoints(endSemesterRequest.getGradePoints());
			endsemnew.setMonthAndYearOfPassing(endSemesterRequest.getMonthAndYearOfPassing());
			endsemnew.setSemesterName(endSemesterRequest.getSemesterName());
			endsemnew.setStudentId(endSemesterRequest.getStudentId());
			endsemnew.setSubjectCode(endSemesterRequest.getSubjectCode());
			endsemnew.setSubjectName(endSemesterRequest.getSubjectName());
			endsemnew.setCredits(endSemesterRequest.getCredits());
			endsemnew.setGpa(endSemesterRequest.getGpa());
			endsemnew.setTotalGradePoints(endSemesterRequest.getTotalGradePoints());
			return endSemesterRespository.save(endsemnew);
		}
	}
	
	
	public List<Endsemester> getEndSemMarks(String studentId,String semesterName){
		List<Endsemester> endSemMarks = endSemesterRespository.findAllByStudentIdAndSemesterName(studentId, semesterName);
		return endSemMarks;
	}
 	

}