public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualShelter petShelter = new VirtualShelter();

		petShelter.addPet(new VirtualCat("The Eater of Worlds"));
		petShelter.addPet(new VirtualCat("Frederick the Great"));
		petShelter.addPet(new VirtualCat("Bob"));
		petShelter.addPet(new VirtualPet("The Amorphous Blob"));

		AppInterface appInterface = new AppInterface(petShelter);

		appInterface.startInterface();
	}
}
