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

	public String toString() {
		String returnString = "Name | Type | Hunger | Thirst | Boredom \n";
		for (String key : petMap.keySet()) {
			VirtualPet pet = petMap.get(key);
			returnString += pet.toString() + "\n";
		}
		return returnString;
	}

}
