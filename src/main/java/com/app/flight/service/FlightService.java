package com.app.flight.service;

import com.app.project.entity.Flight;

import java.util.List;

public interface FlightService {
	
	List<Flight> findAll();
	Flight findById(int flightId);
	Flight save(Flight flight);
	void deleteById(int flightId);
	
}
