package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ssn.mentorapp.model.Faculty;

public interface FacultyRepository extends  MongoRepository<Faculty, String> {

	Optional<Faculty> findByFacultyEmail(String email);
}
