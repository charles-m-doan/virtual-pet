package models;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import models.VirtualPet;
import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
import organicpets.OrganicHorse;

public class VirtualShelterTest {

	public VirtualShelterTest() {
		
	}

	@Test
	public void virtualShelterShouldHave0Pets() {
		int expectedNumberOfPets = 0;
		VirtualShelter testShelter = new VirtualShelter();
		int actualNumberOfPets = testShelter.getNumberOfPets();
		assertEquals(expectedNumberOfPets, actualNumberOfPets);
	}

	@Test
	public void canAddPetToVirtualShelter() {
		int numberOfPetsAfter = 1;
		VirtualShelter testShelter = new VirtualShelter();
		testShelter.addPet(new OrganicDog("boy"));
		int actualNumberOfPets = testShelter.getNumberOfPets();
		assertEquals(numberOfPetsAfter, actualNumberOfPets);

	}

	@Test
	public void canTakePetFromVirtualShelter() {
		int numberOfPetsAfter = 0;
		VirtualShelter testShelter = new VirtualShelter();
		testShelter.addPet(new OrganicDog("Jeff"));
		testShelter.takePet("Jeff");
		int actualNumberOfPets = testShelter.getNumberOfPets();
		assertEquals(numberOfPetsAfter, actualNumberOfPets);
	}

	@Test
	public void canReturnPetToPlayer() {
		VirtualShelter testShelter = new VirtualShelter();
		testShelter.addPet(new OrganicDog("Jeff"));
		VirtualPet removedPet = testShelter.takePet("Jeff");
		assertTrue(removedPet != null);

	}

	@Test
	public void playerCanViewPetStats() {
		VirtualPet testPet = new OrganicDog("dog");
		String stats = testPet.toString();
		System.out.println(stats);
	}

	@Test
	public void playerCanViewStatsForAllPets() {
		VirtualShelter testShelter = new VirtualShelter();
		VirtualPet testPet1 = new OrganicDog("other dog");
		VirtualPet testPet2 = new OrganicCat("Mittens");
		VirtualPet testPet3 = new OrganicHorse("Ed");
		testShelter.addPet(testPet1);
		testShelter.addPet(testPet2);
		testShelter.addPet(testPet3);

		System.out.println(testShelter);
	}
	
	@Test
	public void playerCanPlayWithTwoPets() {
		VirtualShelter testShelter = new VirtualShelter();
		VirtualPet testPet1 = new OrganicDog("other dog");
		VirtualPet testPet2 = new OrganicCat("Mittens");
		VirtualPet testPet3 = new OrganicHorse("Ed");
		testShelter.addPet(testPet1);
		testShelter.addPet(testPet2);
		testShelter.addPet(testPet3);
		
		System.out.println(testShelter);
		testShelter.playWithPets(new String[] {"other dog", "Mittens", "Ed"});
		System.out.println(testShelter);
		
	}
}
