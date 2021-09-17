package com.codeclan.example.Courses.Repositories;

import com.codeclan.example.Courses.Models.Course;
import com.codeclan.example.Courses.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long courseId);
    // FIND CUSTOMER BY HOME TOWN AND BOOKINGS COURSE ID
    List<Customer> findByTownAndBookingsCourseId(String town, Long courseId);
    List<Customer> findByTownAndAgeGreaterThan(String town, Integer age);
}
