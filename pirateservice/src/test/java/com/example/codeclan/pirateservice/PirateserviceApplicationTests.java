package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindPiratesOver30(){
		List<Pirate> found = pirateRepository.findByAgeGreaterThan(30);
		assertEquals(7,found.size());
	}

	@Test
	public void canFindRaidByLocation(){
		List<Raid> raid = raidRepository.findDistinctByLocation("Tortuga");
		assertEquals(1,raid.size());
	}

	@Test
	public void findPiratesByRaidId(){
		List<Pirate> foundPirates = pirateRepository.findByRaidsId(1L);
		assertEquals(1, foundPirates.size());
		assertEquals("Jack", foundPirates.get(0).getFirstName());
	}

	@Test
	public void findShipsByPiratesFirstName(){
		List<Ship> foundShip = shipRepository.findByPiratesFirstName("Jack");
		assertEquals(1,foundShip.size());
	}

	@Test
	public void findRaidsByShipId(){
		List<Raid> foundRaids = raidRepository.findByPiratesShipId(1L);
		assertEquals(1,foundRaids.size());


	}

//	@Test
//	public void createPirate(){
//		Pirate jack = new Pirate("Jack","Sparrow",32,);
//		pirateRepository.save(jack);
//	}

//	@Test void createPirateAndShipAndRaid(){
//		Ship ship = new Ship("The Flying Dutchman");
//		shipRepository.save(ship);
//
//		Pirate pirate1 = new Pirate("Jack","Sparrow",32,ship);
//		pirateRepository.save(pirate1);
//
//		Raid raid1 = new Raid("Glasgow",25);
//		raidRepository.save(raid1);
//
//		pirate1.addRaid(raid1);
//		pirateRepository.save(pirate1);
//
//	}




}
