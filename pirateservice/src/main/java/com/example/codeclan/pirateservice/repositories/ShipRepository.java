package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findByPiratesFirstName (String firstName);
}
