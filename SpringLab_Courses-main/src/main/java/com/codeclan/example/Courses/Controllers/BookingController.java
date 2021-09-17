package com.codeclan.example.Courses.Controllers;

import com.codeclan.example.Courses.Models.Booking;
import com.codeclan.example.Courses.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> findBookingByDate(
            @RequestParam(name="date", required = false) String date
    ){
        if(date != null){
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return  new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value="/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking){
            Booking booking = bookingRepository.findById(id).get();
            booking = updatedBooking;
            bookingRepository.save(booking);
            return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping(value="bookings/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id){
        Booking bookingToDelete = bookingRepository.findById(id).get();
        bookingRepository.delete(bookingToDelete);
        return new ResponseEntity<>(bookingToDelete, HttpStatus.OK);
    }

    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking newBooking){
        bookingRepository.save(newBooking);
        return new ResponseEntity<>(newBooking, HttpStatus.OK);
    }
}
