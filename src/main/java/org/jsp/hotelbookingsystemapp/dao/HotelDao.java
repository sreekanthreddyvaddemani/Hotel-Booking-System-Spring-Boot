package org.jsp.hotelbookingsystemapp.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.Room;
import org.jsp.hotelbookingsystemapp.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDao {
	@Autowired
	private HotelRepository repository;
	
	public Hotel saveHotel(Hotel hotel) {
		return repository.save(hotel);
	}

	public Hotel updateHotel(Hotel hotel) {
		return repository.save(hotel);
	}



	public Optional<Hotel> findHotel(int id) {
		return repository.findById(id);
	}

	

	public List<Hotel> filter(String address, String dop) {
		return repository.filter(address,dop);
	}

}
