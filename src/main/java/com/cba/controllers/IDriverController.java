package com.cba.controllers;

import java.util.Date;
import java.util.List;

import com.cba.entities.Driver;
import com.cba.services.IDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cba.exception.DriverNotFoundException;

//accepts request from outside sources like webbrowser
//controller+HTTP protocals
@RestController
/*The @RequestMapping annotation ensures that HTTP requests to /Product are mapped to the Product() method or Product class.
It is used to map web requests onto specific handler classes and/or handler methods*/
@RequestMapping(value = "driver")
//@CrossOrigin annotation enables cross-origin resource sharing only for this specific method.
@CrossOrigin("http://localhost:4200")
public class IDriverController {
    //Autowiring makes the container to search the bean configurations and do the collaboration among beans,
    @Autowired
    private IDriverService service;
    Logger logger= LoggerFactory.getLogger(IDriverController.class);
    /*The @PostMapping annotated methods in the @Controller annotated classes handle the HTTP POST
	requests matched with given URI expression.*/
    @PostMapping(path = "/insert")
    public ResponseEntity<Object> insertDriver(@RequestBody Driver driver) {
        logger.info("Method:InsertDriver");
        Driver driver1 = service.insertDriver(driver);
//        ResponseEntity<Object> responseEntity = new ResponseEntity(driver1, HttpStatus.OK);
//        System.out.println("response entity=" + responseEntity);
//        return responseEntity;
        return new ResponseEntity<>(driver1,HttpStatus.CREATED);
    }

    /*	The @GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET
     * requests matched with given URI expression.
     */
    @GetMapping(path = "/viewDriver/{driverId}")
    public ResponseEntity<Driver> viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
        logger.info("Method:ViewDriver");
        Driver driver = service.viewDriver(driverId);
        if (driver == null) {
            throw new DriverNotFoundException("Product not found for id=" + driverId);
        }
        return new ResponseEntity<Driver>(driver, new HttpHeaders(), HttpStatus.OK);
    }

    //mapping HTTP PUT requests onto specific handler methods.
    @PutMapping(path = "/update")
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
        logger.info("Method:UpdateDriver");
        driver = service.updateDriver(driver);
        return new ResponseEntity<Driver>(driver, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/getbestdrivers")
    public ResponseEntity<List<Driver>> viewBestDrivers() {
        logger.info("Method:ViewBestDrivers");
        List<Driver> list = service.viewBestDrivers();
        return new ResponseEntity<List<Driver>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{driverId}")
    public String deleteDriver(@PathVariable int driverId) {
        logger.info("Method:DeleteDriver");
        service.deleteDriver(driverId);
        return "Driver Deleted";
    }
}


