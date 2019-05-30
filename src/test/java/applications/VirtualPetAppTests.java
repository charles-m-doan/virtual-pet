package applications;
import org.junit.Test;

import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
import robotpets.RobotCat;
import robotpets.RobotDog;

public class VirtualPetAppTests {

	VirtualShelter vs = new VirtualShelter();

	public VirtualPetAppTests() {
		vs.addPet(new OrganicCat("Mittens"));
		vs.addPet(new OrganicDog("Jeff"));
		vs.addPet(new RobotDog("Kujo"));
		vs.addPet(new RobotCat("Whiskers"));
		vs.addPet(new OrganicCat("Ninja"));
		vs.addPet(new OrganicDog("George"));
		vs.addPet(new RobotDog("K-9"));
		vs.addPet(new RobotCat("Terminator"));
	}

	@Test
	public void testBasicTicking() {
		vs.tickPets();
		vs.printPetStatusTables();

		vs.tickPets();
		vs.printPetStatusTables();

		vs.tickPets();
		vs.printPetStatusTables();

		vs.tickPets();
		vs.printPetStatusTables();

		vs.tickPets();
		vs.printPetStatusTables();

		vs.removePet("K-9");
		vs.printPetStatusTables();
	}

}
