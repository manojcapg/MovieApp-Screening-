package com.capg.movieapp.repository;


import com.capg.movieapp.model.Theatre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, String> {

	List<Theatre> findByCityAndTicketCostLessThanEqual(String city, double ticketCost);



}

