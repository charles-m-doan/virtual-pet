import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
		testShelter.addPet(new VirtualPet());
		int actualNumberOfPets = testShelter.getNumberOfPets();
		assertEquals(numberOfPetsAfter, actualNumberOfPets);

	}

	@Test
	public void canTakePetFromVirtualShelter() {
		int numberOfPetsAfter = 0;
		VirtualShelter testShelter = new VirtualShelter();
		testShelter.addPet(new VirtualPet());
		testShelter.takePet("Jeff");
		int actualNumberOfPets = testShelter.getNumberOfPets();
		assertEquals(numberOfPetsAfter, actualNumberOfPets);
	}

	@Test
	public void canReturnPetToPlayer() {
		VirtualShelter testShelter = new VirtualShelter();
		testShelter.addPet(new VirtualPet());
		VirtualPet removedPet = testShelter.takePet("Jeff");
		assertTrue(removedPet != null);

	}

	@Test
	public void playerCanViewPetStats() {
		VirtualPet testPet = new VirtualPet();
		String stats = testPet.toString();
		System.out.println(stats);
	}

	@Test
	public void playerCanViewStatsForAllPets() {
		VirtualShelter testShelter = new VirtualShelter();
		VirtualPet testPet1 = new VirtualPet();
		VirtualPet testPet2 = new VirtualPet("Mittens");
		VirtualPet testPet3 = new VirtualPet("Ed");
		testShelter.addPet(testPet1);
		testShelter.addPet(testPet2);
		testShelter.addPet(testPet3);

		System.out.println(testShelter);
	}
}
