package org.jsp.hotelbookingsystemapp.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.Room;
import org.jsp.hotelbookingsystemapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao {
	@Autowired
	private RoomRepository repository;
	

	public Room saveRoom(Room room) {
		return repository.save(room);
	}

	public Room updateRoom(Room room) {
		return repository.save(room);
	}



	public Optional<Room> findRoom(int id) {
		return repository.findById(id);
	}

	public List<Room> findAll() {
		return repository.findAll();
	}



}
