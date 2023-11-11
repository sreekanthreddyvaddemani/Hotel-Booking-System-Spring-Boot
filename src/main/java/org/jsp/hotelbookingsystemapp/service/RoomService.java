package org.jsp.hotelbookingsystemapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dao.AdminDao;
import org.jsp.hotelbookingsystemapp.dao.HotelDao;
import org.jsp.hotelbookingsystemapp.dao.RoomDao;
import org.jsp.hotelbookingsystemapp.dto.Admin;
import org.jsp.hotelbookingsystemapp.dto.EmailConfiguration;
import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.Room;
import org.jsp.hotelbookingsystemapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	@Autowired
	private HotelDao hotelDao;

	@Autowired
	private RoomDao roomDao;

	

	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room, int hotel_id) {
		Optional<Hotel> recHotel = hotelDao.findHotel(hotel_id);
		ResponseStructure<Room> structure = new ResponseStructure<>();
		if (recHotel.isPresent()) {
			Hotel h = recHotel.get();
			h.getRooms().add(room);
			room.setHotel(h);
			hotelDao.updateHotel(h);
//			hotelDao.saveHotel(hotel);
			structure.setData(roomDao.saveRoom(room));
			structure.setMessage("Hotel Added Successfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Room>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

}
