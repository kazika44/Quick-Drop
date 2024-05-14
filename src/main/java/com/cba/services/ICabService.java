package com.cba.services;

import java.util.List;

import com.cba.entities.Cab;

public interface ICabService {

    Cab insertCab(Cab cab);

    Cab findCabById(int cabId);

    Cab updateCab(Cab cab);

    List<Cab> viewCabsOfType(String CarType);

    int countCabsOfType(String carType);

    Cab deleteCab(int cabId);

}

