package com.ssn.mentorapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Endsemester;


@Repository
public interface EndSemesterRespository extends MongoRepository<Endsemester, String>{

	List<Endsemester> findAllByStudentIdAndSemesterName( String studentId,String semesterName);
	
	Optional<Endsemester> findBySemesterNameAndStudentIdAndSubjectCode(String semesterName, String studentId,String subjectCode);
}
