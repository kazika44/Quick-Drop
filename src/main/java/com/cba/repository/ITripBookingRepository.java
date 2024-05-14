package com.cba.repository;

import java.util.List;

import com.cba.entities.TripBooking;

public interface ITripBookingRepository {
    public void insertTripBooking(TripBooking pro);

    public List<TripBooking> ViewAllTripsCustomer(int id);

    public TripBooking updateTripBooking(TripBooking booking);

    public String deleteTripBooking(int id);

    public float calculateBill(int id);
}
