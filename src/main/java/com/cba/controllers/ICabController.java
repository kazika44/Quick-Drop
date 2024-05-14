package com.cba.controllers;

import java.util.List;

import com.cba.entities.Cab;
import com.cba.exception.CabNotFoundException;
import com.cba.services.ICabService;
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

@RestController
//accepts request from outside sources like webbrowser
//controller+HTTP protocals
@RequestMapping(value = "Cab")
	/*The @RequestMapping annotation ensures that HTTP requests to /cabbooking are mapped to the cabbooking() method or Product class.
	It is used to map web requests onto specific handler classes and/or handler methods*/
@CrossOrigin("http://localhost:4200")
//@CrossOrigin annotation enables cross-origin resource sharing only for this specific method.
public class ICabController {
    private static final String String = null;
    @Autowired
    //Autowiring makes the container to search the bean configurations and do the collaboration among beans,
    private ICabService service;
		
		/*The @PostMapping annotated methods in the @Controller annotated classes handle the HTTP POST
		requests matched with given URI expression.*/

    @PostMapping(path = "/insert")
    public ResponseEntity<Object> insertCab(@RequestBody Cab cab) {
        Cab cab1 = service.insertCab(cab);
        ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(cab1, HttpStatus.OK);
        System.out.println("response entity=" + responseEntity);
        return responseEntity;
    }
    /*	The @GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET
     * requests matched with given URI expression.
     */

    @GetMapping(path = "/getdetails/{cabId}")
    public ResponseEntity<Cab> findCabById(@PathVariable int cabId) throws CabNotFoundException {
        Cab cab = service.findCabById(cabId);
        if (cab == null) {
            throw new CabNotFoundException("product not found for id=" + cabId);
        }

        return new ResponseEntity<Cab>(cab, new HttpHeaders(), HttpStatus.OK);
    }

// mapping HTTP PUT requests onto specific handler methods.

    @PutMapping(path = "/update")
    public ResponseEntity<Cab> updateCab(@RequestBody Cab cab) {
        cab = service.updateCab(cab);
        return new ResponseEntity<Cab>(cab, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping(path = "/getCarTypes")
    public ResponseEntity<List<Cab>> ViewAll() {
        List<Cab> list = service.viewCabsOfType(String);
        return new ResponseEntity<List<Cab>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/countcartypes/{carType}")
    public ResponseEntity<Integer> countCabsOfType(@PathVariable String carType) throws CabNotFoundException {
        int cab = service.countCabsOfType(carType);
        if (cab == 0) {
            throw new CabNotFoundException("Cab not found for id=" + carType);
        }
        return new ResponseEntity<Integer>(cab, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{cabId}")
    public String deleteCab(@PathVariable("cabId") int cabId) {
        service.deleteCab(cabId);
        return "cab infomation deleted";
    }
}



