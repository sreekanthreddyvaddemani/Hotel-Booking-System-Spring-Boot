package org.jsp.hotelbookingsystemapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.User;
import org.jsp.hotelbookingsystemapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);

	}
	
	public Optional<User> findbyphone(long phone) {
		return repository.findbyphone(phone);
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> findbyid(int id) {
		return repository.findById(id);
	}

	public Optional<User> verifyUser(String email, String password) {
		return repository.verifyUser(email, password);
	}







}
