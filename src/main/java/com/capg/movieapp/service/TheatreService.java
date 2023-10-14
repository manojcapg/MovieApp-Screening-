package com.capg.movieapp.service;

import java.util.List;

import com.capg.movieapp.model.Theatre;

public interface TheatreService{
	
	Theatre addTheatre(Theatre theatre);
	
	List<Theatre> viewAll();
	
	Theatre updateTicketCost(String theatreId, double ticketCost);
	
	Theatre viewTheatreByID(String theatreId);
	
	List<Theatre> viewTheatreByCityAndTicketCost(String city, double ticketCost);
	
}