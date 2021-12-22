package com.ssn.mentorapp.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUserName(String username); 
	
	Optional<User> findByEmail(String email);

	Boolean existsByUserName(String username);
	
	Boolean existsByEmail(String email);
}
