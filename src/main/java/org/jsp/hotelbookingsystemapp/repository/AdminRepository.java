package org.jsp.hotelbookingsystemapp.repository;


import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.Admin;
import org.jsp.hotelbookingsystemapp.dto.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("select a from Admin a where a.phone=?1 and a.password=?2")
	public Optional<Admin> verifyAdmin(long phone, String password);
	
	
	@Query("select a.hotels from Admin a where a.id=?1")
	public List<Hotel> adminHotel(int admin_id);
}
