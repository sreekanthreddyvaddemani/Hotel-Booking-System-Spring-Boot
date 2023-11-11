package org.jsp.hotelbookingsystemapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class RoomBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String customer_name;
	@Column(nullable = false)
	private long customer_phone;
	@Column(nullable = false)
	private String customer_email;
	@Column(nullable = false)
	private int room_no;
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false)
	private String time_of_booking;
	@Column(nullable = false,unique = true)
	private int no_of_rooms;
	@Column(nullable = false)
	private String status;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private User user;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Hotel hotel;
	

}
