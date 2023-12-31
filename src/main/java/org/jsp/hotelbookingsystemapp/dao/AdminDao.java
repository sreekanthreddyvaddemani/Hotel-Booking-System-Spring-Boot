package org.jsp.hotelbookingsystemapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.Admin;
import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AdminDao {

	@Autowired
	private AdminRepository repository;
	
	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);

	}

	public Admin updateAdmin(Admin admin) {
		return repository.save(admin);
	}

	public Optional<Admin> findbyid(int id) {
		return repository.findById(id);
	}

	public Optional<Admin> verifyAdmin(long phone, String password) {
		return repository.verifyAdmin(phone, password);
	}

	public List<Hotel> adminHotel(int admin_id){
		return repository.adminHotel(admin_id);
	}


}
