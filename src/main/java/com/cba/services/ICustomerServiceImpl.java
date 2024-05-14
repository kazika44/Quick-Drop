package com.cba.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import com.cba.entities.ConfirmationToken;
import com.cba.repository.IConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
//import com.corejava.Repository.ICustomerRepository;
//import com.corejava.entity.Customer;

import com.cba.entities.Customer;
import com.cba.repository.ICustomerRepository;

/*Annotate all our service classes with  @Service .all our business logic should be in Service classes*/

@Service
public class ICustomerServiceImpl implements ICustomerService {
    /*Spring auto wire other beans into your classes using@Autowired annotation*/


    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IConfirmationTokenRepository iConfirmationTokenRepository;

    @Autowired
    EmailService emailService;

    public ResponseEntity<Customer> insertCustomer(Customer customer) {
        if(iCustomerRepository.existsByUserEmail(customer.getEmail()))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customer);
            //"Error! email already in use"
        }
        Customer returnedCustomer=iCustomerRepository.insertCustomer(customer);
        ConfirmationToken confirmationToken=new ConfirmationToken(customer);
        Integer randomNumber = ThreadLocalRandom.current().nextInt();
        confirmationToken.setConfirmationToken(randomNumber.toString());
        confirmationToken.setCreateDate(new Date());
        iConfirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customer.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:9995/customer/confirm-account?token="+confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);

        System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());

        return ResponseEntity.ok().body(returnedCustomer);
    }


    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        ConfirmationToken token = iConfirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null)
        {
//            Customer customer = iCustomerRepository.findByUserEmailIgnoreCase(token.getCustomer().getEmail());
//            customer.setEnabled(true);
            iCustomerRepository.updateCustomer(token.getCustomer());
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }

    public Customer updateCustomer(Customer customer) {

        return iCustomerRepository.updateCustomer(customer);
    }

    public Customer deleteCustomer(int customerId) {

        return iCustomerRepository.deleteCustomer(customerId);
    }

    public List<Customer> viewCustomers() {
        return iCustomerRepository.viewCustomers();
    }

    public Customer viewCustomer(int customerId) {
        return iCustomerRepository.viewCustomer(customerId);
    }

    public Customer validateCustomer(String username, String password) {
        return iCustomerRepository.validateCustomer(username, password);
    }

}