package com.cba.services;

import java.util.List;

import com.cba.entities.Customer;
import org.springframework.http.ResponseEntity;


public interface ICustomerService {

    ResponseEntity<Customer> insertCustomer(Customer customer);

    ResponseEntity<?> confirmEmail(String confirmationToken);

    Customer updateCustomer(Customer customer);

    Customer deleteCustomer(int customerId);

    List<Customer> viewCustomers();

    Customer viewCustomer(int customerId);

    Customer validateCustomer(String username, String password);

    //void deleteCustomer(int customerId);


}		