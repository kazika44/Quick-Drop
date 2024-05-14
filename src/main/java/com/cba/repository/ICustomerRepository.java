package com.cba.repository;

import java.util.List;

import com.cba.entities.ConfirmationToken;
import com.cba.entities.Customer;
import org.springframework.stereotype.Repository;

//import com.corejava.entity.Customer;


public interface ICustomerRepository {

    Customer insertCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer deleteCustomer(int customerId);

    List<Customer> viewCustomers();

    Customer viewCustomer(int customerId);

    Customer validateCustomer(String username, String password);

    Customer findByUserEmailIgnoreCase(String email);

    boolean existsByUserEmail(String email);

//    ConfirmationToken findByConfirmationToken(String );

    // deleteCustomer(int customerId);

    //void updateCustomer(Customer customer);

    //Customer deleteCustomer(int customerId);


}




