package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Semester;

@Repository
public interface SemesterRespository extends MongoRepository<Semester, String>{
	
	Optional<Semester> findBySemesterName(String semesterName);

}
