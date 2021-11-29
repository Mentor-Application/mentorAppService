package com.ssn.mentorapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Student;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
	
	@Query("{studentName :  /^?0/ ,registerNumber : /^?1/ , branch : ?2 , section : ?3 , periodOfStudy : ?4}")
	List<Student> findAllByStudentNameAndRegisterNumberAndBranchAndSectionAndPeriodOfStudy(String name,String regNum,String branch,String section,String period);
	
	List<Student> findAllByStudentNameOrRegisterNumberOrBranchOrSectionOrPeriodOfStudy(String name,String regNum,String branch,String section,String period);
	
	Optional<Student> findByEmailId(String email);
	
	List<Student> findAllByMentorId(String mentorId);
}
