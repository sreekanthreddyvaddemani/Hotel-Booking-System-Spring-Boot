package org.jsp.hotelbookingsystemapp.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String hotelname;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private int no_of_rooms;
	@Column(nullable = false,name="data_of available")
	private String dop;
	@Column(nullable = false)
	private String hotelimg;
	@ManyToOne
	@JoinColumn(name="admin_id")
	@JsonIgnore
	private Admin admin;
	@OneToMany(mappedBy = "hotel")
	private List<Room> rooms;
	@OneToMany(mappedBy = "hotel")
	private List<RoomBook> roombooking;
}
