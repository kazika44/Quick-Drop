package com.cba.services;

import java.util.List;

import com.cba.entities.TripBooking;

public interface ITripBookingService {

    public void insertTripBooking(TripBooking pro);

    public List<TripBooking> ViewAllTripsCustomer(int id);

    public TripBooking updateTripBooking(TripBooking booking);

    public String deleteTripBooking(int id);

    public float calculateBill(int id);

}
