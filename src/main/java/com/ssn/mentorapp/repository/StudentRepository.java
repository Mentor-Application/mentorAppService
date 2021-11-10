package com.ssn.mentorapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Student;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
