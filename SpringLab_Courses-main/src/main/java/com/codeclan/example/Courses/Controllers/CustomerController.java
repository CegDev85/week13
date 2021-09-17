package com.codeclan.example.Courses.Controllers;

import com.codeclan.example.Courses.Models.Customer;
import com.codeclan.example.Courses.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> findCustomersByCourseId(
            @RequestParam(name="courseId", required = false) Long id,
            @RequestParam(name="town", required = false) String town,
            @RequestParam(name="age", required = false) Integer age
    ){
        if(town != null && age != null){
            return new ResponseEntity<>(customerRepository.findByTownAndAgeGreaterThan(town, age), HttpStatus.OK);
        }
        if(id != null && town != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseId(town, id), HttpStatus.OK);
        }
        if(id != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }


}
