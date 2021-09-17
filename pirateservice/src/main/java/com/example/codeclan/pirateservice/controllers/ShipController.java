package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    @GetMapping(value="/ships")
    public ResponseEntity<List<Ship>> getAllShips(){
        return new ResponseEntity<>(shipRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/ships/{id}")
    public ResponseEntity getShip(@PathVariable Long id){
        return new ResponseEntity(shipRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/ships")
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship){
        shipRepository.save(ship);
        return new ResponseEntity<>(ship, HttpStatus.CREATED);
    }

    @GetMapping(value = "/ships/pirates")
    public ResponseEntity<List<Ship>> findShipsThatHavePiratesNamedQueryString(
            @RequestParam(name = "named") String name //can stack these lines
    ){
        return new ResponseEntity<>(shipRepository.findByPiratesFirstName(name), HttpStatus.OK);
    }

}
