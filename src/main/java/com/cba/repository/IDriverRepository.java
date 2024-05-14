package com.cba.repository;

import java.util.List;

import com.cba.entities.Driver;

public interface IDriverRepository {

    Driver insertDriver(Driver driver);

    Driver updateDriver(Driver driver);

    //Driver findDriverById(int driverId);
    Driver deleteDriver(int driverId);

    List<Driver> viewBestDrivers();

    Driver viewDriver(int driverId);

}
