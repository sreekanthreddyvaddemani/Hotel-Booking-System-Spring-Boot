package org.jsp.hotelbookingsystemapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.jsp.hotelbookingsystemapp.dto.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	
	
	@Query("select h from Hotel h where h.address=?1 and h.dop=?2")
	public List<Hotel> filter(String address, String dop);

//	@Query("select b from Hotel b where b.from=?1 and b.to=?2 and b.dop=?3")
//	public List<Hotel> filter(String from, String to, LocalDate dop);

}
