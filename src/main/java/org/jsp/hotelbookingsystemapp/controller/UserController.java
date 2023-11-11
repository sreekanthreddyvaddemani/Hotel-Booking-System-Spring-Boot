package org.jsp.hotelbookingsystemapp.controller;

import java.util.List;

import org.jsp.hotelbookingsystemapp.dao.UserDao;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.User;
import org.jsp.hotelbookingsystemapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService service;
	
	
	@Autowired
	private UserDao dao;

	@PostMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping(value = "/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable int id) {
		return service.findbyid(id);
	}
	
	@PostMapping(value = "/users/verifybyemail")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email,
			@RequestParam String password) {
		return service.verifyUser(email, password);
	}

}
