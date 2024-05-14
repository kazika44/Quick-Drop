package com.cba.services;

import java.util.List;

import com.cba.entities.TripBooking;
import com.cba.repository.ITripBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITripBookingServiceImpl implements ITripBookingService {

    @Autowired
    ITripBookingRepository itripbookingrepositoryi;

    @Override
    public void insertTripBooking(TripBooking pro) {
        itripbookingrepositoryi.insertTripBooking(pro);
        return;
    }

    @Override
    public List<TripBooking> ViewAllTripsCustomer(int id) {
        return itripbookingrepositoryi.ViewAllTripsCustomer(id);
    }

    @Override
    public TripBooking updateTripBooking(TripBooking booking) {
        return itripbookingrepositoryi.updateTripBooking(booking);
    }

    @Override
    public String deleteTripBooking(int id) {
        return itripbookingrepositoryi.deleteTripBooking(id);
    }

    @Override
    public float calculateBill(int id) {
        return itripbookingrepositoryi.calculateBill(id);
    }


}
