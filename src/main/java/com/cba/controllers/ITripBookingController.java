package com.cba.controllers;

import java.util.List;

import com.cba.entities.TripBooking;
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

import com.cba.services.ITripBookingService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "TripBooking")
@CrossOrigin("http://localhost:4200")
@Api(value = "ITripBookingController")
public class ITripBookingController {
    @Autowired
    ITripBookingService itripbookingservicei;

    @PostMapping("/insert")  //localhost:9995/Tripbooking/insert
    public ResponseEntity<Boolean> insert(@RequestBody TripBooking pro) {
        itripbookingservicei.insertTripBooking(pro);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
        System.out.println("response entity=" + responseEntity);
        return responseEntity;
    }

    @GetMapping("/viewall/{id}")  //localhost:9995/Tripbooking/viewAll
    public ResponseEntity<List<TripBooking>> viewall(@PathVariable int id) {
        List<TripBooking> list = itripbookingservicei.ViewAllTripsCustomer(id);
        return new ResponseEntity<List<TripBooking>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update")  //localhost:9995/Tripbooking/update
    public ResponseEntity<TripBooking> updateProduct(@RequestBody TripBooking booking) {
        booking = itripbookingservicei.updateTripBooking(booking);
        return new ResponseEntity<TripBooking>(booking, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}") //localhost:9995/TripBooking/delete/{customerId}
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        itripbookingservicei.deleteTripBooking(id);
        return new ResponseEntity<String>("Record TripBooking Deleted", HttpStatus.OK);

    }

    @GetMapping("/viewbill/{id}")
    public float calculate(@PathVariable int id) {
        return itripbookingservicei.calculateBill(id);
    }
}
