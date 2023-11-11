package org.jsp.hotelbookingsystemapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dao.AdminDao;
import org.jsp.hotelbookingsystemapp.dao.HotelDao;
import org.jsp.hotelbookingsystemapp.dto.Admin;
import org.jsp.hotelbookingsystemapp.dto.EmailConfiguration;
import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.ResponseStructure;
import org.jsp.hotelbookingsystemapp.dto.Room;
import org.jsp.hotelbookingsystemapp.dto.RoomBook;
import org.jsp.hotelbookingsystemapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private AdminDao adminDao;
	

	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(Hotel hotel, int admin_id) {
		Optional<Admin> recAdmin = adminDao.findbyid(admin_id);
		ResponseStructure<Hotel> structure = new ResponseStructure<>();
		if (recAdmin.isPresent()) {
			Admin a = recAdmin.get();
			a.getHotels().add(hotel);
			hotel.setAdmin(a);
			adminDao.updateAdmin(a);
			structure.setData(hotelDao.saveHotel(hotel));
			structure.setMessage("Hotel Added Successfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	
	
	
	public ResponseEntity<ResponseStructure<List<Hotel>>> filter(String address,String dop) {
		ResponseStructure<List<Hotel>> structure = new ResponseStructure<>();
		structure.setData(hotelDao.filter(address, dop));
		structure.setMessage("List of Hoteles");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Hotel>>>(structure, HttpStatus.OK);
	}

//	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(Hotel hotel, int admin_id, int hotel_id) {
//		Optional<Admin> recAdmin = adminDao.findbyid(admin_id);
//		ResponseStructure<Hotel> structure = new ResponseStructure<>();
//		if (recAdmin.isPresent()) {
////			Admin a = recAdmin.get();
////			a.getHoteles().add(hotel);
////			hotel.setAdmin(a);
////			adminDao.updateAdmin(a);
//			hotel.setId(hotel_id);
//			hotelDao.updateHotel(hotel);
//			structure.setData(hotel);
//			structure.setMessage("Hotel Updated Successfully");
//			structure.setStatusCode(HttpStatus.ACCEPTED.value());
//			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.ACCEPTED);
//		}
//		throw new IdNotFoundException();
//	}

		
	public ResponseEntity<ResponseStructure<Hotel>> findHotel(int id) {
		ResponseStructure<Hotel> structure = new ResponseStructure<>();
		Optional<Hotel> recHotel = hotelDao.findHotel(id);
		if (recHotel.isPresent()) {
			structure.setData(recHotel.get());
			structure.setMessage("HOTEL Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	
	public ResponseEntity<ResponseStructure<List<RoomBook>>> findPending(int id) {
		ResponseStructure<List<RoomBook>> structure = new ResponseStructure<>();
		Optional<Hotel> recHotel = hotelDao.findHotel(id);
	
		if (recHotel.isPresent()) {
			Hotel h=recHotel.get();
			System.out.println(h.getRoombooking());
			structure.setData(h.getRoombooking());
			structure.setMessage("HOTEL Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<RoomBook>>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}


}
