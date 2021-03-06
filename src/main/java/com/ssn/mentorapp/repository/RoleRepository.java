package com.ssn.mentorapp.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ssn.mentorapp.model.ERole;
import com.ssn.mentorapp.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
		
		Optional<Role> findByRoleName(ERole name);
}
