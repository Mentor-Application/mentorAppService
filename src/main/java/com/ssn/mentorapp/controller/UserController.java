package com.ssn.mentorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.model.User;
import com.ssn.mentorapp.payload.request.ResetPasswordRequest;
import com.ssn.mentorapp.payload.response.MessageResponse;
import com.ssn.mentorapp.repository.UserRepository;
import com.ssn.mentorapp.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	

	
	@PostMapping("/resetPassword")
	public ResponseEntity<?> resetPasword(@RequestBody ResetPasswordRequest resetPasswordRequest){
		User existingUser = userRepository.findByEmail(resetPasswordRequest.getEmail()).get();
		if(existingUser != null) {
			System.out.println(encoder.encode(resetPasswordRequest.getPassword()));
			if(encoder.matches(resetPasswordRequest.getPassword(), existingUser.getPassword())) {
				if(resetPasswordRequest.getNewPassword().equals(resetPasswordRequest.getRepeatPassword())) {
					existingUser.setPassword(resetPasswordRequest.getNewPassword());
				    return ResponseEntity.ok(existingUser);
				}
				else {
					return ResponseEntity.badRequest().body(new MessageResponse("new password and repeat password are not same"));
				}
			}
			else {
				return ResponseEntity.badRequest().body(new MessageResponse("wrong credentials"));
			}
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("user not found"));
		}
	}

}
