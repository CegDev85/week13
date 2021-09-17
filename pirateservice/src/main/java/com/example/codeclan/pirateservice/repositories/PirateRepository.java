package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {

    List<Pirate> findByAge(int age);
    List<Pirate> findByFirstName(String firstName);
    Pirate findDistinctByFirstName(String firstName);
    List<Pirate> findDistinctByFirstNameOrLastName(String lastName, String firstName);

    List<Pirate> findByAgeGreaterThan(int age);
    List<Pirate> findByRaidsId(Long id);


}
