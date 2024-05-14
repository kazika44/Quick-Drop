package com.cba.services;

import java.time.LocalDateTime;
import java.util.List;

import com.cba.entities.TripBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cba.entities.Admin;
import com.cba.repository.IAdminRepository;

//@Service annotation is used in your service layer and annotates classes that perform service tasks
@Service
public class IAdminServiceImpl implements IAdminService {

    //Autowiring makes the container to search the bean configurations and do the collaboration among beans,
    @Autowired
    IAdminRepository iadminrepositoryi;


    @Override
    public Admin insertAdmin(Admin admin) {
        iadminrepositoryi.insertAdmin(admin);
        return admin;
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return iadminrepositoryi.updateAdmin(admin);
    }

    @Override
    public Admin deleteAdmin(int adminId) {
        return iadminrepositoryi.deleteAdmin(adminId);
    }

    @Override
    public List<TripBooking> getAllTrips(int customerId) {
        return iadminrepositoryi.getAllTrips(customerId);
    }

    @Override
    public List<TripBooking> getTripsCabwise() {
        return iadminrepositoryi.getTripsCabwise();
    }

    @Override
    public List<TripBooking> getTripsCustomerwise() {
        return iadminrepositoryi.getTripsCustomerwise();
    }

    @Override
    public List<TripBooking> getTripsDatewise() {
        return iadminrepositoryi.getTripsDatewise();
    }

    @Override
    public List<TripBooking> getAllTripsForDays(int customerid, LocalDateTime fromdate, LocalDateTime todate) {
        return iadminrepositoryi.getAllTripsForDays(customerid, fromdate, todate);
    }

}
