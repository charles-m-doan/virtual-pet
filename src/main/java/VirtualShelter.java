import java.util.HashMap;

public class VirtualShelter {

	private HashMap<String, VirtualPet> petMap;

	public VirtualShelter() {
		petMap = new HashMap<String, VirtualPet>();

	}

	public int getNumberOfPets() {
		int numberOfPets = petMap.size();
		return numberOfPets;
	}

	public void addPet(VirtualPet virtualPet) {
		petMap.put(virtualPet.getName(), virtualPet);

	}

	public VirtualPet takePet(String name) {
		return petMap.remove(name);

	}

}
