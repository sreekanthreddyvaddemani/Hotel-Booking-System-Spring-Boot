package org.jsp.hotelbookingsystemapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String room_no;
	@Column(nullable = false)
	private double cost;
	@Column(nullable = false)
	private int no_beds;
	@Column(nullable = false)
	private String room_type;
	@Column(nullable = false)
	private String acOrNonac;
	@Column(nullable = false)
	private String no_of_members;
	@Column(nullable = false)
	private String roomimg;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Hotel hotel;
	

}
