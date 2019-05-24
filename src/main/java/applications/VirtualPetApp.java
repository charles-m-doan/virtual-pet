package applications;
import models.VirtualPet;
import models.VirtualShelter;
import organicpets.OrganicCat;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualShelter petShelter = new VirtualShelter();

		petShelter.addPet(new OrganicCat("The Eater of Worlds"));
		petShelter.addPet(new OrganicCat("Frederick the Great"));
		petShelter.addPet(new OrganicCat("Bob"));
		petShelter.addPet(new VirtualPet("The Amorphous Blob"));

		AppInterface appInterface = new AppInterface(petShelter);

		appInterface.startInterface();
	}
}
