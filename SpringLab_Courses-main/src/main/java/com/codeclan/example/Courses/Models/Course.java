package com.codeclan.example.Courses.Models;

import com.codeclan.example.Courses.Models.resources.Rating;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="town")
    private String town;

    @Column(name="rating")
    private int rating;

    @JsonIgnoreProperties("course")
    @OneToMany(mappedBy = "course")
    private List<Booking> bookings;

    public Course(String name, String town, Rating rating) {
        this.name = name;
        this.town = town;
        this.rating = rating.getRating();
        this.bookings = new ArrayList<>();
    }

    public Course() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating.getRating();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
