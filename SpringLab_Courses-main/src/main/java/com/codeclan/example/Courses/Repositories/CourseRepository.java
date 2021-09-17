package com.codeclan.example.Courses.Repositories;

import com.codeclan.example.Courses.Models.Course;
import com.codeclan.example.Courses.Models.resources.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);
    List<Course> findByBookingsCustomerId(Long customerId);
}
