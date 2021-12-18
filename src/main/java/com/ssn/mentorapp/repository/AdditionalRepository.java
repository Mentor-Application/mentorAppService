package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Additional;
import com.ssn.mentorapp.model.Disciplinary;

@Repository
public interface AdditionalRepository extends MongoRepository<Additional,String> {
	Optional<Additional> findByStudentId(String StudentId);
}
