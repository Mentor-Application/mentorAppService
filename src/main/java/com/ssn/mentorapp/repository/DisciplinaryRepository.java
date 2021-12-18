package com.ssn.mentorapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Disciplinary;
@Repository
public interface DisciplinaryRepository extends MongoRepository<Disciplinary,String> {
	
	Optional<Disciplinary> findByStudentId(String StudentId);
	
//	List<Disciplinary> findAllByStudentIdAndSemesterName(String StudentId,String semesterName);
	
}
