package com.codeclan.example.Courses.Controllers;

import com.codeclan.example.Courses.Models.Course;
import com.codeclan.example.Courses.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getCourses(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name="customerId", required = false) Long customerId
    ){
        if(rating != null){
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if(customerId != null){
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
