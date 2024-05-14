package com.cba;

import com.cba.entities.Cab;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cba.repository.ICabRepository;
import com.cba.services.ICabServicesImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCab {
    @InjectMocks
    private ICabServicesImpl service;

    @Mock
    private ICabRepository Dao;

    @Test
    public void updateCabtest() {
        Cab cab1 = new Cab();

        cab1.setCabId(1);
        cab1.setCarType("SUV");
        cab1.setPerKmRate(88);

        Mockito.when(Dao.updateCab(cab1)).thenReturn(cab1);
    }

    @Test
    public void deleteCabtest() {
        Cab cab1 = new Cab();

        cab1.setCabId(1);
        cab1.setCarType("SUV");
        cab1.setPerKmRate(88);

        Mockito.when(Dao.deleteCab(0)).thenReturn(cab1);

    }
}