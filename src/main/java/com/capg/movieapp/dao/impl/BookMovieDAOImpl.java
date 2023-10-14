package com.capg.movieapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.movieapp.exception.InvalidEntityException;
import com.capg.movieapp.model.Booking;
import com.capg.movieapp.repository.BookMovieRepository;
import com.capg.movieapp.dao.BookMovieDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import com.capg.movieapp.model.Booking;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository

public class BookMovieDAOImpl implements BookMovieDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	BookMovieRepository bookMovieRepository;

	@Override
	public Booking addBooking(Booking booking) {
		return bookMovieRepository.save(booking);
	}

	@Override
	public Booking updateTicketAndAmount(String bookingId, int noOfTickets, double amount)
			throws InvalidEntityException {
		Optional<Booking> optionalBooking = bookMovieRepository.findById(bookingId);

		if (optionalBooking.isPresent()) {
			Booking booking = optionalBooking.get();
			// Update the number of tickets and amount
			booking.setNumberOfTickets(noOfTickets);
			booking.setAmount(amount);
			// Save the updated booking
			return bookMovieRepository.save(booking);
		} else {
			// Booking not found, throw an exception
			throw new InvalidEntityException("Booking Id " + bookingId + " does not exist");
		}
	}

	@Override
	public Booking deleteBooking(String bookingId) throws InvalidEntityException {

		Booking booking = bookMovieRepository.findById(bookingId)
				.orElseThrow(() -> new InvalidEntityException("Booking not found"));

		bookMovieRepository.delete(booking);

		return booking;
	}

	@Override
	public List<Booking> viewAll() {

		return bookMovieRepository.findAll();
	}

	@Override
	public Optional<Booking> viewBookingById(String bookingId) {
		return bookMovieRepository.findById(bookingId);
	}

	@Override
	public List<Booking> viewBookingByBookingDate(LocalDate bookingDate) {

		return bookMovieRepository.findByBookingDate(bookingDate);
	}

}
