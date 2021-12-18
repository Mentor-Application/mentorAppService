package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.model.ExtraCurricular;
import com.ssn.mentorapp.model.Overall;

@Repository
public interface OverallRepository extends MongoRepository<Overall,String> {
	
	Optional<Overall> findByStudentId(String StudentId);
}
