package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capg.movieapp.dao.ScreeningDAO;
import com.capg.movieapp.model.Screening;
import com.capg.movieapp.service.impl.ScreeningServiceImpl;

class ScreeningServiceImplTest {

    @InjectMocks
    private ScreeningServiceImpl screeningService;

    @Mock
    private ScreeningDAO screeningDAO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }



    @Test
    void testViewAll() {
        // Create a list of sample screenings for testing
        List<Screening> screenings = new ArrayList<>();
        // Add some sample screenings to the list

        // Mock the behavior of screeningDAO.viewAll()
        when(screeningDAO.viewAll()).thenReturn(screenings);

        // Call the service method to get a list of screenings
        List<Screening> result = screeningService.viewAll();

        assertNotNull(result); // Check if the result is not null
        
    }

    @Test
    void testViewByScreenID() {
        // Create a sample screening ID for testing
        String screeningId = "123";

        // Create a sample screening for testing
        Screening screening = new Screening();
        screening.setScreeningId(screeningId);
        // Set other properties of the screening

        
        // Mock the behavior of screeningDAO.viewByScreenID()
        when(screeningDAO.viewByScreenID(screeningId)).thenReturn(screening);

        
        // Call the service method to get a screening by ID
        Screening result = screeningService.viewByScreenID(screeningId);

        
        
        assertNotNull(result); // Check if the result is not null
        
        assertEquals(screeningId, result.getScreeningId()); // Check if the ID matches
       
    }


   

   
}
