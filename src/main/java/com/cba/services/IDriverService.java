package com.cba.services;

import java.util.List;

import com.cba.entities.Driver;

public interface IDriverService {

    Driver insertDriver(Driver driver);

    Driver viewDriver(int driverId);

    // Driver findDriverById(int driverId);

    Driver updateDriver(Driver driver);

    List<Driver> viewBestDrivers();

    Driver deleteDriver(int driverId);


}