package applications;

import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
import robotpets.RobotCat;
import robotpets.RobotDog;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualShelter vs = new VirtualShelter();
		vs.addPet(new OrganicCat("Mittens"));
		vs.addPet(new OrganicDog("Jeff"));
		vs.addPet(new RobotDog("Kujo"));
		vs.addPet(new RobotCat("Whiskers"));
		vs.addPet(new OrganicCat("Ninja"));
		vs.addPet(new OrganicDog("George"));
		vs.addPet(new RobotDog("K-9"));
		vs.addPet(new RobotCat("Terminator"));
		
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
