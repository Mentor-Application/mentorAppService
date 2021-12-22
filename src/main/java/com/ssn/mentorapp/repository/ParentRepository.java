package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Parent;
import com.ssn.mentorapp.model.ParentUser;

@Repository
public interface ParentRepository extends MongoRepository<ParentUser, String> {

	
	Optional<ParentUser> findByEmailId(String email);
	
	Optional<ParentUser> findByStudentId(String studentId);
}
