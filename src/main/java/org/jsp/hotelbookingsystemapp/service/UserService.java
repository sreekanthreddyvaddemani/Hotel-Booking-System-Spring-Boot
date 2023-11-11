package org.jsp.hotelbookingsystemapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dao.UserDao;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.User;
import org.jsp.hotelbookingsystemapp.exception.IdNotFoundException;
import org.jsp.hotelbookingsystemapp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(dao.saveUser(user));
		structure.setMessage("user Saved Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}



	

	public ResponseEntity<ResponseStructure<User>> findbyid(int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.findbyid(id);
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("user Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verifyUser(email,password);
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("user verified");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}




}
