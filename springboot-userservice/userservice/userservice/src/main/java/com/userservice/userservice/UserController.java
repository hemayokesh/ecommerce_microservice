package com.userservice.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cm.userservice.userservice.dto.AuthRequest;
import cm.userservice.userservice.dto.AuthResponse;
import cm.userservice.userservice.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	 private final UserService userService;
	    private final JwtUtil jwtUtil;

	    private final AuthenticationManager authenticationManager;

	    
	    
	    @GetMapping("/all")
	    public ResponseEntity<List<UserEntity>> getAllUsers() {
	        List<UserEntity> users = userService.getAllUsers();
	        return ResponseEntity.ok(users);
	    }
	    @PostMapping("/register")
	    public String register(@Valid @RequestBody RegisterRequest request) {
	        UserEntity user = userService.registerUser(request);
	        return "User registered successfully with ID: " + user.getId();
	    }

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
	        try {
	            authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	            );

	            String token = jwtUtil.generateToken(authRequest.getUsername());

	            return ResponseEntity.ok(new AuthResponse(token));
	        } catch (BadCredentialsException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }
	    
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
	    	UserEntity user = userService.getUserById(id);
	        return ResponseEntity.ok(user);
	    }
	}


