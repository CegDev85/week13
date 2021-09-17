package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaidRepository extends JpaRepository<Raid, Long> {

    List<Raid> findDistinctByLocation(String location);

    List<Raid> findByPiratesShipId (Long id); //have to check pirates ship as ship has a list of pirates


}