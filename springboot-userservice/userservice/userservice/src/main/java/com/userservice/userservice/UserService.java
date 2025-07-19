package com.userservice.userservice;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cm.userservice.userservice.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	    

	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserEntity registerUser(RegisterRequest request) {
	    	UserEntity user = UserEntity.builder()
	                .username(request.getUsername())
	                .email(request.getEmail())
	                .password(passwordEncoder.encode(request.getPassword()))
	                .role(request.getRole())
	                .build();
	        return userRepository.save(user);
	    }

	    public UserEntity getUserByUsername(String username) {
	        return userRepository.findByUsername(username)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    }
	    
	    public List<UserEntity> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public UserEntity getUserById(Long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
	    }
		
	}


