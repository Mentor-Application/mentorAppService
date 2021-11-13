package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Parent;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String> {

	
	Optional<Parent> findByEmailId(String email);
}
