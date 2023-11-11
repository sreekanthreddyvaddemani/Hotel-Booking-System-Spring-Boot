package org.jsp.hotelbookingsystemapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dao.AdminDao;
import org.jsp.hotelbookingsystemapp.dto.Admin;
import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.exception.IdNotFoundException;
import org.jsp.hotelbookingsystemapp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AdminService {
	@Autowired
	private AdminDao dao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setData(dao.saveAdmin(admin));
		structure.setMessage("admin Saved Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setData(dao.updateAdmin(admin));
		structure.setMessage("Admin Updated Successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);

	}

	public ResponseEntity<ResponseStructure<Admin>> findbyid(int id) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> recAdmin = dao.findbyid(id);
		if (recAdmin.isPresent()) {
			structure.setData(recAdmin.get());
			structure.setMessage("Admin Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(long phone, String password) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> recAdmin = dao.verifyAdmin(phone, password);
		if (recAdmin.isPresent()) {
			structure.setData(recAdmin.get());
			structure.setMessage("Admin verified");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

	
	public ResponseEntity<ResponseStructure<List<Hotel>>> adminHotel(int admin_id) {
		ResponseStructure<List<Hotel>> structure = new ResponseStructure<>();
		structure.setData(dao.adminHotel(admin_id));
		structure.setMessage("List of Admin Buses");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Hotel>>>(structure, HttpStatus.OK);
	}
	

}
