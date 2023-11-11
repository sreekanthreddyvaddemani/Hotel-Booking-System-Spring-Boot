package org.jsp.hotelbookingsystemapp.service;

import java.sql.Struct;
import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dao.HotelDao;
import org.jsp.hotelbookingsystemapp.dao.RoomBookDao;
import org.jsp.hotelbookingsystemapp.dao.UserDao;
import org.jsp.hotelbookingsystemapp.dto.EmailConfiguration;
import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.RoomBook;
import org.jsp.hotelbookingsystemapp.dto.User;
import org.jsp.hotelbookingsystemapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoomBookService extends Thread{

	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoomBookDao roombookDao;

	@Autowired
	private ReservationApiEmailService service;

	@Autowired
	private EmailConfiguration configuration;

	public synchronized ResponseEntity<ResponseStructure<RoomBook>> saveRoomBook(RoomBook roombook, int user_id, int hotel_id) {
		Optional<User> recUser = userDao.findbyid(user_id);
		Optional<Hotel> recHotel = hotelDao.findHotel(hotel_id);
		ResponseStructure<RoomBook> structure = new ResponseStructure<>();
		if (recUser.isPresent() && recHotel.isPresent()) {
			User u = recUser.get();
			Hotel h = recHotel.get();
			u.getRoombokings().add(roombook);
			h.getRoombooking().add(roombook);
			roombook.setUser(u);
			roombook.setHotel(h);
			structure.setData(roombookDao.saveRoomBook(roombook));
			hotelDao.updateHotel(h);
			userDao.updateUser(u);
			structure.setMessage("Room Added Wait");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<RoomBook>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	
	public ResponseEntity<ResponseStructure<RoomBook>> accepetd(RoomBook room,int hotel_id) {
		Optional<User> recUser = userDao.findbyphone(room.getCustomer_phone());
		Optional<Hotel> recHotel = hotelDao.findHotel(hotel_id);
		ResponseStructure<RoomBook> structure = new ResponseStructure<>();
		if (recUser.isPresent() && recHotel.isPresent()) {
			User u = recUser.get();
			Hotel h = recHotel.get();
            room.setStatus("ACCEPETED");
            u.getRoombokings().add(room);
			h.getRoombooking().add(room);
			room.setUser(u);
			room.setHotel(h);
            roombookDao.updateRoomBook(room);
			configuration.setTo(room.getCustomer_email());
			configuration.setSubject("Ticket for BOOKING ");
			configuration.setText("ROOM BOOKING SUCCEFULLY COMPLETED");
			String message = service.sendEmail(configuration);
			structure.setData(roombookDao.updateRoomBook(room));
			hotelDao.updateHotel(h);
			userDao.updateUser(u);
			structure.setMessage("Room Added Wait");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<RoomBook>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
		}
	
	public ResponseEntity<ResponseStructure<RoomBook>> rejected(RoomBook room,int hotel_id) {
		Optional<User> recUser = userDao.findbyphone(room.getCustomer_phone());
		Optional<Hotel> recHotel = hotelDao.findHotel(hotel_id);
		ResponseStructure<RoomBook> structure = new ResponseStructure<>();
		if (recUser.isPresent() && recHotel.isPresent()) {
			User u = recUser.get();
			Hotel h = recHotel.get();
            room.setStatus("REJECTED");
            u.getRoombokings().add(room);
			h.getRoombooking().add(room);
			room.setUser(u);
			room.setHotel(h);
            roombookDao.updateRoomBook(room);
			configuration.setTo(room.getCustomer_email());
			configuration.setSubject("HOTEL ROOM BOOKING UPDATE ");
			configuration.setText("SORRY ROOM NOT AVAILABLE");
			String message = service.sendEmail(configuration);
			structure.setData(roombookDao.updateRoomBook(room));
			hotelDao.updateHotel(h);
			userDao.updateUser(u);
			structure.setMessage("Room Added Wait");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<RoomBook>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
		}



}
