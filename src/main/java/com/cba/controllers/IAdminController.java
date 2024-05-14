package com.cba.controllers;

import java.time.LocalDateTime;
import java.util.List;

import com.cba.entities.Admin;
import com.cba.entities.TripBooking;
import com.cba.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/*accept request from outside source like web browser*/
@RestController

/*mapping the web request onto the method and it can handle our requests.
customer are mapped to the customer() methods*/
@RequestMapping(value = "admin")

/*@CrossOrigin annotation allows all origins,all headers and HTTP methods specified in the @Request mapping annotation*/
@CrossOrigin("http://localhost:4200")

@Api(value = "IAdminController")
public class IAdminController {

    /*This annotation is used to auto-wire spring bean on setter methods,constructor and instance variable.
    internally create a object.*/
    @Autowired
    IAdminService iadminservicei;

    /* @Postmapping can maps HTTP POST.mapped to insert
     *@Request body method parameter is bounded to the body of the web request
     *Customer should bind to the insert request
     *ResponseEntity is an extension of HTTPEntity which has parameters
     *@RequestBody method parameter is bounded to the body of the web request*/
    @PostMapping("/insert")
    public ResponseEntity<Admin> insert(@RequestBody Admin pro) {
        iadminservicei.insertAdmin(pro);
        return new ResponseEntity<Admin>(pro, new HttpHeaders(), HttpStatus.OK);

    }

    /*Annotation for mapping HTTP PUT request onto updateCustomer(method)
     *@RequestBody annotation is used to indicating Customer should be bind to the update request*/
    @PutMapping("/update")  //localhost:9995/Admin/update
    public ResponseEntity<Admin> updateProduct(@RequestBody Admin admin) {
        admin = iadminservicei.updateAdmin(admin);
        return new ResponseEntity<Admin>(admin, new HttpHeaders(), HttpStatus.OK);
    }

    /*DeleteMapping annotation mapping HTTP delete requests onto deleteCustomer(method).*/
    @DeleteMapping(path = "/delete/{id}") //localhost:9995/delete/{empId}
	/*@path variable methods parameter should be bound to URI a template variable 
	request path deleteCustomer will bind variable customer id*/
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        iadminservicei.deleteAdmin(id);
        return new ResponseEntity<String>("Record of Admin Deleted", HttpStatus.OK);
    }

    @GetMapping("/alltrips/{id}")  //localhost:9995/admin/getall
    public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable int id) {
        List<TripBooking> list = iadminservicei.getAllTrips(id);
        return new ResponseEntity<List<TripBooking>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/alltripscabwise")  //localhost:9995/admin/alltripscabwise
    public ResponseEntity<List<TripBooking>> getTripsCabwise() {
        List<TripBooking> list = iadminservicei.getTripsCabwise();
        return new ResponseEntity<List<TripBooking>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/alltripscustomerwise")  //localhost:9995/admin/alltripscustomerwise
    public ResponseEntity<List<TripBooking>> getTripsCustomerwise() {
        List<TripBooking> list = iadminservicei.getTripsCustomerwise();
        return new ResponseEntity<List<TripBooking>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/alltripsdatewise")  //localhost:9090/addmin/alltripsdatewise
    public ResponseEntity<List<TripBooking>> getTripsDatewise() {
        List<TripBooking> list = iadminservicei.getTripsDatewise();
        return new ResponseEntity<List<TripBooking>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/alltripscustomerwise/{id}/{fromdate}/{todate}")
    //localhost:9995/admin/alltripscustomerwise/{id}/{fromdate}/{todate}
    public ResponseEntity<List<TripBooking>> getAllTripsForDays(@PathVariable int id, @PathVariable LocalDateTime fromDate, @PathVariable LocalDateTime toDate) {
        List<TripBooking> list = iadminservicei.getAllTripsForDays(id, fromDate, toDate);
        return new ResponseEntity<List<TripBooking>>(list, new HttpHeaders(), HttpStatus.OK);
    }


}
