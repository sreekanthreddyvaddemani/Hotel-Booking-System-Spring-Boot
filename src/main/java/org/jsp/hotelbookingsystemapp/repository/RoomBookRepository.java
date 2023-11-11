package org.jsp.hotelbookingsystemapp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.hotelbookingsystemapp.dto.RoomBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface RoomBookRepository extends JpaRepository<RoomBook, Integer> {

}
