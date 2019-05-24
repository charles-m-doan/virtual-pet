package models;
import java.util.HashMap;
import java.util.Set;

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
		String returnString = "Name | Type | Health | Hunger | Thirst | Boredom \n";
		for (String key : petMap.keySet()) {
			VirtualPet pet = petMap.get(key);
			returnString += pet.toString() + "\n";
		}
		return returnString;
	}
	
	public void playWithPets(String[] petNames) {
		for (int i = 0; i < petNames.length; i++) {
			String key = petNames[i];
			VirtualPet pet = petMap.get(key);
			pet.play();
		}
	}

	/*public void feedMultiplePets(String[] petNames) {
		for (int i = 0; i < petNames.length; i++) {
			String key = petNames[i];
			VirtualPet pet = petMap.get(key);
			pet.feed();
		}
	}

	public void waterMultiplePets(String[] petNames) {
		for (int i = 0; i < petNames.length; i++) {
			String key = petNames[i];
			VirtualPet pet = petMap.get(key);
			pet.water();
		}
	}
	*/
	
	public void vetVisitMultiplePets(String[] petNames) {
		for (int i = 0; i < petNames.length; i++) {
			String key = petNames[i];
			VirtualPet pet = petMap.get(key);
			pet.vetVisit();
		}
	}

}
