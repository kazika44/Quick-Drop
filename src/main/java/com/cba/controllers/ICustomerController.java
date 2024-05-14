package com.cba.controllers;

//import java.net.http.HttpHeaders;

import java.util.List;

import com.cba.entities.Customer;
import com.cba.exception.CabNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cba.exception.CustomerNotFoundException;
import com.cba.services.ICustomerService;

/*accept request from outside source like web browser*/
   /*mapping the web request onto the method and it can handle our requests.
      customer are mapped to the customer() methods*/
@RestController
@RequestMapping("/customer")
/*@CrossOrigin annotation allows all origins,all headers and HTTP methods specified in the @Request mapping annotation*/
@CrossOrigin("http://localhost:4200")
public class ICustomerController {
	
	/*This annotation is used to auto-wire spring bean on setter methods,constructor and instance variable.
	internally create a object.*/

    @Autowired
    ICustomerService iCustomerService;

    /* @Postmapping can maps HTTP POST.mapped to insert
     *@Request body method parameter is bounded to the body of the web request
     *Customer should bind to the insert request
     *ResponseEntity is an extension of HTTPEntity which has parameters
     *@RequestBody method parameter is bounded to the body of the web request*/

    @PostMapping(path = "/insert")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
        ResponseEntity<Customer> responseEntity = iCustomerService.insertCustomer(customer);
//        if (customer.getCustomerId() == 0)
//            throw new CustomerNotFoundException("Oops!!No customer found for given Id");
        System.out.println("response entity=True");
        return responseEntity;
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.POST,RequestMethod.GET })
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")Integer confirmationToken) {
        return iCustomerService.confirmEmail(confirmationToken.toString());
    }

    /*Annotation for mapping HTTP PUT request onto updateCustomer(method)
     *@RequestBody annotation is used to indicating Customer should be bind to the update request*/

    @PutMapping(path = "/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        customer = iCustomerService.updateCustomer(customer);
        if ((customer.getCustomerId() == 0) || (customer.getUsername() == null) || (customer.getMobileNumber() == 0) || (customer.getEmail() == null) || (customer.getPassword() == null) || (customer.getAddress() == null))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /*DeleteMapping annotation mapping HTTP delete requests onto deleteCustomer(method).*/

    @DeleteMapping(path = "/delete/{customerId}")
	
	/*@path variable methods parameter should be bound to URI a template variable 
	request path deleteCustomer will bind variable customer id*/
    public String deleteCustomer(@PathVariable("customerId") int customerId) {
        iCustomerService.deleteCustomer(customerId);
        return "Customer Deleted";
    }

    /*This annotation for HTTP get requests onto the(viewCustomers) methods.*/
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Customer>> getAll() throws CabNotFoundException {
        List<Customer> list = iCustomerService.viewCustomers();
        if (list.isEmpty())
            throw new CabNotFoundException("Oops!!The List is Empty");

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //mapping HTTP GET
    @GetMapping(path = "/viewCustomer/{customerId}")

    /*The viewCustomer will bind variable customer id*/
    public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") int customerId) {
        Customer customer = iCustomerService.viewCustomer(customerId);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found for id=" + customerId);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /*mapping HTTP validation onto the validateCustomer method*/
    @GetMapping(path = "/validateCustomer/{username}/{password}")
    /*The validateCustomer will bind variables username ,password*/

    public ResponseEntity<Customer> validateCustomer(@PathVariable String username, @PathVariable String password) {
        Customer customer = iCustomerService.validateCustomer(username, password);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}