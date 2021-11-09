package com.ssn.mentorapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.mentorapp.repository.RoleRepository;
import com.ssn.mentorapp.model.ERole;
import com.ssn.mentorapp.model.Role;
import com.ssn.mentorapp.model.User;
import com.ssn.mentorapp.payload.request.AuthenticationRequest;
import com.ssn.mentorapp.payload.request.SignUpRequest;
import com.ssn.mentorapp.payload.response.AuthenticationResponse;
import com.ssn.mentorapp.payload.response.MessageResponse;
import com.ssn.mentorapp.repository.UserRepository;
import com.ssn.mentorapp.security.jwt.jwtUtils;
import com.ssn.mentorapp.security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private jwtUtils jwtUtils;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private RoleRepository roleRepository;

	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody AuthenticationRequest authenticationRequest){
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt,userDetails.getId(),userDetails.getUsername(),userDetails.getEmail(),roles));
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest){
		if (userRepository.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken!"));
		}
		// need to add email validation method
		if (userRepository.existsByUserName(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUserName(),encoder.encode(signUpRequest.getPassword()), signUpRequest.getEmail());
		
		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role studentRole = roleRepository.findByRoleName(ERole.STUDENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(studentRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByRoleName(ERole.ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mentor":
					Role mentorRole = roleRepository.findByRoleName(ERole.MENTOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(mentorRole);

					break;
				case "faculty":
					Role facultyRole = roleRepository.findByRoleName(ERole.FACULTY)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(facultyRole);
					break;
				case "parent":
					Role parentRole = roleRepository.findByRoleName(ERole.PARENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(parentRole);
					break;
				default:
					Role userRole = roleRepository.findByRoleName(ERole.STUDENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(user);
	}
	
	
}
