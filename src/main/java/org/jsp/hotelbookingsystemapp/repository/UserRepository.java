package org.jsp.hotelbookingsystemapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> verifyUser(String email, String password);

	
	
	@Query("select u from User u where u.phone=?1")
	public Optional<User> findbyphone(long phone);
	
	
}
