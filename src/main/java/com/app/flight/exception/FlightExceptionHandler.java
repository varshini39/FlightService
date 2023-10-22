package com.app.flight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FlightExceptionHandler {
	
	// Handling general exceptions
	@ExceptionHandler
	public ResponseEntity<FlightErrorResponse> handleException(Exception exc) {
		FlightErrorResponse error = new FlightErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	// Handles ID not found exception
	@ExceptionHandler
	public ResponseEntity<FlightErrorResponse> handleException(IdNotFoundException exc) {
		FlightErrorResponse error = new FlightErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
