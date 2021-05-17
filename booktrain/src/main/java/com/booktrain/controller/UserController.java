package com.booktrain.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booktrain.dto.UserDTO;
import com.booktrain.model.Ticket;
import com.booktrain.service.UserService;

@RestController
public class UserController {
	private Logger logger= LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/users/{id}/history")
	public ResponseEntity<List<?>> history(@PathVariable("id") Integer userId) {

		List<Ticket> tickets=userService.getHisotry(userId);

		return new ResponseEntity<>(tickets,HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
		
		Integer userId=userService.registerUser(userDTO);
		logger.info("User registered Successfully");
		return new ResponseEntity<>("User Registered Successfully UserId"+userId,HttpStatus.OK);
	}

}
