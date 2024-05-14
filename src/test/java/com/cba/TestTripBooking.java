package com.cba;

import com.cba.entities.TripBooking;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cba.repository.repositoryImpl.ITripBookingRepositoryImpl;
import com.cba.services.ITripBookingServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTripBooking {
    @InjectMocks
    private ITripBookingServiceImpl service;

    @Mock
    private ITripBookingRepositoryImpl Dao;

    @Test
    public void insertTripbooking() {
        TripBooking tripbooking = new TripBooking();

        tripbooking.setTripBookingId(1);
        tripbooking.setBill(8);
        tripbooking.setCustomerId(2);
        tripbooking.setDistanceInKm(7765);
        tripbooking.setDriverId(7);
        //tripbooking.setToLocalDateTime(2/12/2007 13:09:42.87);
        tripbooking.setFromLocation("bangalore");
        tripbooking.setStatus(true);
        //tripbooking.setFromLocalDateTime(76/98);
        tripbooking.setToLocation("hydrabad");
    }

    @Test
    public void updateTripBooking() {
        TripBooking tp = new TripBooking();
        tp.setTripBookingId(12);
        tp.setFromLocation("n");
        tp.setToLocation("vaizag");
        tp.setDistanceInKm(65);
        tp.setBill(6);
        Mockito.when(Dao.updateTripBooking(tp)).thenReturn(tp);

    }
}