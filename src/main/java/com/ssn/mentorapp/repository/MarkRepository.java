package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.Marks;

@Repository
public interface MarkRepository extends MongoRepository<Marks, String>{

	Optional<Marks> findBySemesterNameAndStudentIdAndSubjectCodeAndExamType(String semesterName, String studentId,String subjectcode,String examtype);
}
