package org.jsp.hotelbookingsystemapp.controller;

import java.util.List;

import org.jsp.hotelbookingsystemapp.dao.RoomBookDao;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.RoomBook;
import org.jsp.hotelbookingsystemapp.service.RoomBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RoomBookController extends Thread{
	@Autowired
	private RoomBookService service;
	
	@Autowired
	private RoomBookDao dao;

	@PostMapping(value="/roombook/{user_id}/{hotel_id}")
	public synchronized ResponseEntity<ResponseStructure<RoomBook>> saveRoomBook(@RequestBody RoomBook room,@PathVariable int user_id,@PathVariable int hotel_id){
		return service.saveRoomBook(room, user_id,hotel_id);
	}
	
	@PostMapping(value="/roombook/accepted/{hotel_id}")
	public ResponseEntity<ResponseStructure<RoomBook>> accepted(@RequestBody RoomBook room,@PathVariable int hotel_id){
		return service.accepetd(room,hotel_id);
	}
	
	
	@PostMapping(value="/roombook/rejected/{hotel_id}")
	public ResponseEntity<ResponseStructure<RoomBook>> rejected(@RequestBody RoomBook room,@PathVariable int hotel_id){
		return service.rejected(room,hotel_id);
	}

	
}
