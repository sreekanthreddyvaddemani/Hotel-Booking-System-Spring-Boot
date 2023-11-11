package org.jsp.hotelbookingsystemapp.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private String message;
	private int statusCode;

}
