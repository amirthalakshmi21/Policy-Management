package com.demo.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.UserRepository;
import com.demo.dto.LoginRequest;
import com.demo.entity.User;

@CrossOrigin
@RestController
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
	        Map<String, Object> response = new HashMap<>();

	        User user = userRepository.findByUsername(request.getUsername());

	        if (user != null && user.getPassword().equals(request.getPassword())) {
	            response.put("success", true);
	            response.put("message", "Login successful");
	            return ResponseEntity.ok(response);
	        } else {
	            response.put("success", false);
	            response.put("message", "Invalid credentials");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        }
	    }
	}



