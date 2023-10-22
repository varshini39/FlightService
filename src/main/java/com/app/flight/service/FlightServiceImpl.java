package com.app.flight.service;

import com.app.flight.entity.Flight;
import com.app.flight.exception.IdNotFoundException;
import com.app.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {
	
	private FlightRepository flightRepository;
	
	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
	
	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}
	
	@Override
	public Flight findById(int flightId) {
		Optional<Flight> searchFlight = flightRepository.findById(flightId);
		
		Flight flight = null;
		if(searchFlight.isPresent()) {
			flight = searchFlight.get();
		} else {
			throw new IdNotFoundException("Did not find the flight id - " + flightId);
		}
		return flight;
	}
	
	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}
	
	@Override
	public void deleteById(int flightId) {
		flightRepository.deleteById(flightId);
	}
}
