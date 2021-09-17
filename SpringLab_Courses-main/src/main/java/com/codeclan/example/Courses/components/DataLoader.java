package com.codeclan.example.Courses.components;

import com.codeclan.example.Courses.Models.Booking;
import com.codeclan.example.Courses.Models.Course;
import com.codeclan.example.Courses.Models.Customer;
import com.codeclan.example.Courses.Models.resources.Rating;
import com.codeclan.example.Courses.Repositories.BookingRepository;
import com.codeclan.example.Courses.Repositories.CourseRepository;
import com.codeclan.example.Courses.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer calum = new Customer("Calum", "Glasgow", 60);
        customerRepository.save(calum);
        Customer craig = new Customer("Craig", "Renfrew", 20);
        customerRepository.save(craig);
        Course codeClan = new Course("Codeclan", "Glasgow", Rating.FIVE);
        courseRepository.save(codeClan);
        Course dbad = new Course("Don't be a dick", "Easterhouse", Rating.ONE);
        courseRepository.save(dbad);
        Booking booking = new Booking("28-10-2022", calum, dbad);
        bookingRepository.save(booking);
        Booking booking1 = new Booking("20-09-2021", calum, codeClan);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("20-09-2021", craig, codeClan);
        bookingRepository.save(booking2);
    }
}
