package com.example.demo1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.bean.Flight;

public class FlightDetailStub {
	private static Map<Integer, Flight> fli = new HashMap<Integer, Flight>();
	private static int idIndex = 3;

	//populate initial wrecks
	static {
		Flight a = new Flight(1, "VF45", 200, "12/09/19", "Chennai", "pune", 3, "JetAirways", 150);
		fli.put(1, a);
		Flight b = new Flight(2, "DG45", 350, "20/09/19", "Bangalore", "pune", 3, "JetAirways", 150);
		fli.put(2, b);
		Flight c = new Flight(3, "ET45", 420, "16/09/19", "Kolkata", "pune", 3, "JetAirways", 150);
		fli.put(3, c);
	}

	public static List<Flight> list() {
		return new ArrayList<Flight>(fli.values());
	}

	public static Flight create(Flight flight) {
		idIndex += 1;
		flight.setId(idIndex);
		fli.put(idIndex, flight);
		return flight;
	}

	public static Flight get(int id) {
		return fli.get(id);
	}

	public static Flight update(int id, Flight flight) {
		fli.put(id, flight);
		return flight;
	}

	public static Flight delete(int id) {
		return fli.remove(id);
	}
}
