package com.cba;

import com.cba.entities.Customer;
import com.cba.services.ICustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cba.repository.ICustomerRepository;
//import com.cg.hims.entities.Agent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCustomer {
    @InjectMocks
    private ICustomerServiceImpl service;

    @Mock
    private ICustomerRepository Dao;

    @Test
    public void insertCustomerTest1() {
        Customer customer1 = new Customer();

        customer1.setCustomerId(8);
        customer1.setUsername("sachin");
        customer1.setMobileNumber(738496753);
        customer1.setPassword("99abc");
        customer1.setEmail("sac.12@gmail.com");
        customer1.setAddress("14,bangalore");


        Mockito.when(Dao.insertCustomer(customer1)).thenReturn(customer1);
    }

    @Test
    public void deleteCustomerTest1() {
        Customer customer1 = new Customer();

        customer1.setCustomerId(8);
        customer1.setUsername("sachin");
        customer1.setMobileNumber(73849675L);
        customer1.setPassword("99abc");
        customer1.setEmail("sac.12@gmail.com");
        customer1.setAddress("14,bangalore");


        Mockito.when(Dao.deleteCustomer(0)).thenReturn(customer1);

    }
}


