package org.jsp.hotelbookingsystemapp.controller;


import java.util.List;

import org.jsp.hotelbookingsystemapp.dto.Admin;
import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {

	
	@Autowired
	private AdminService service;

	@PostMapping(value = "/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@PutMapping(value = "/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin) {
		return service.updateAdmin(admin);
	}

	@GetMapping(value = "/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable int id) {
		return service.findbyid(id);
	}

	@PostMapping(value = "/admin/verifybyphone")
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(@RequestParam long phone,
			@RequestParam String password) {
		System.out.println("exicuted");
		return service.verifyAdmin(phone, password);
	}
	
	
	@GetMapping(value="/admin/hotels/{admin_id}")
	public ResponseEntity<ResponseStructure<List<Hotel>>> adminHotel(@PathVariable int admin_id){
		return service.adminHotel(admin_id);
	}
	

	
	
	
	
}
