package com.cba.repository;

import java.util.List;

import com.cba.entities.Cab;

public interface ICabRepository {
    Cab insertCab(Cab cab);

    Cab findCabById(int cabId);

    Cab updateCab(Cab cab);

    List<Cab> viewCabsOfType(String carType);

    Cab deleteCab(int cabId);

    int countCabsOfType(String CarType);

}
