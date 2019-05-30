package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import organicpets.OrganicCat;
import organicpets.OrganicDog;

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
		VirtualPet testPet3 = new OrganicCat("Ninja");
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
		VirtualPet testPet3 = new OrganicCat("Ninja");
		testShelter.addPet(testPet1);
		testShelter.addPet(testPet2);
		testShelter.addPet(testPet3);

		testShelter.printPetStatusTables();

		ArrayList<String> petNames = new ArrayList<String>();
		petNames.add("other dog");
		petNames.add("Mittens");
		try {
			testShelter.playWithPets(petNames);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		testShelter.printPetStatusTables();
		//assertTrue(false);
	}
}
