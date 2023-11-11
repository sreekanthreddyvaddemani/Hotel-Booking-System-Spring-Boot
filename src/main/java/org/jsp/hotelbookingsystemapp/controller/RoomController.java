package org.jsp.hotelbookingsystemapp.controller;


import java.time.LocalDate;
import java.util.List;

import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.Room;
import org.jsp.hotelbookingsystemapp.service.HotelService;
import org.jsp.hotelbookingsystemapp.service.RoomService;
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
public class RoomController {

	@Autowired
	private RoomService service;

	@PostMapping(value="/hotel/room/{hotel_id}")
	public ResponseEntity<ResponseStructure<Room>> saveHotel(@RequestBody Room room,@PathVariable int hotel_id){
		return service.saveRoom(room, hotel_id);
	}

	

	
}
