package org.jsp.hotelbookingsystemapp.controller;


import java.time.LocalDate;
import java.util.List;

import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.Room;
import org.jsp.hotelbookingsystemapp.dto.RoomBook;
import org.jsp.hotelbookingsystemapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HotelController {

	@Autowired
	private HotelService service;

	@PostMapping(value="/hotel/{admin_id}")
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(@RequestBody Hotel hotel,@PathVariable int admin_id){
		return service.saveHotel(hotel, admin_id);
	}

	
	
	@GetMapping(value="/hotel/filter")
	public ResponseEntity<ResponseStructure<List<Hotel>>> filter(@RequestParam String address,@RequestParam String dop){
		return service.filter(address,dop);
	}



	@GetMapping(value="/hotel/{id}")
	public ResponseEntity<ResponseStructure<Hotel>> findHotel(@PathVariable int id){
		return service.findHotel(id);
	}
	

	@GetMapping(value="/hotel/pending/{id}")
	public ResponseEntity<ResponseStructure<List<RoomBook>>> findPending(@PathVariable int id){
		return service.findPending(id);
	}


	

	
}
