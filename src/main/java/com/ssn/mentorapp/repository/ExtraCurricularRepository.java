package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Disciplinary;
import com.ssn.mentorapp.model.ExtraCurricular;

@Repository
public interface ExtraCurricularRepository extends MongoRepository<ExtraCurricular,String> {
	Optional<ExtraCurricular> findByStudentId(String StudentId);
}
