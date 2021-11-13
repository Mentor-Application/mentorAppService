package com.ssn.mentorapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Student;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	
	Optional<Student> findByEmailId(String email);
	
	List<Student> findAllByMentorId(String mentorId);
}
