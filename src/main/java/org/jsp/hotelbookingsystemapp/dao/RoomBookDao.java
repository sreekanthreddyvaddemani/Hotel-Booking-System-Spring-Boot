package org.jsp.hotelbookingsystemapp.dao;

import java.util.List;
import java.util.Optional;


import org.jsp.hotelbookingsystemapp.dto.RoomBook;
import org.jsp.hotelbookingsystemapp.repository.RoomBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class RoomBookDao {

	@Autowired
	private RoomBookRepository repository;

	public RoomBook saveRoomBook(RoomBook room) {
		return repository.save(room);
	}
	
	public RoomBook updateRoomBook(RoomBook room) {
		return repository.save(room);
	}

}
