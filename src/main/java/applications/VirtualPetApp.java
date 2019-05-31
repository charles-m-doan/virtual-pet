package applications;

import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
import robotpets.RobotCat;
import robotpets.RobotDog;

public class VirtualPetApp {

	public static void main(String[] args)
		{
		VirtualShelter vs = new VirtualShelter();
		vs.addPet(new OrganicCat("Mittens"));
		vs.addPet(new OrganicDog("Jeff"));
		vs.addPet(new OrganicCat("Ninja"));
		vs.addPet(new OrganicDog("George"));
		vs.addPet(new RobotDog("K-9"));
		vs.addPet(new RobotCat("Terminator"));

		AppInterface appInterface = new AppInterface(vs);
		appInterface.startInterface();

		}
}
