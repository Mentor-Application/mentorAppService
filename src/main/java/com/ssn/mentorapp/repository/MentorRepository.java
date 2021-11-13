package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Mentor;

@Repository
public interface MentorRepository extends MongoRepository<Mentor, String> {
	
	Optional<Mentor> findByEmail(String email);

}
