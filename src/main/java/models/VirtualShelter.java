package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import organicpets.OrganicPet;
import robotpets.RobotPet;

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

	/*
	 * public void feedMultiplePets(String[] petNames) { for (int i = 0; i <
	 * petNames.length; i++) { String key = petNames[i]; VirtualPet pet =
	 * petMap.get(key); pet.feed(); } }
	 * 
	 * public void waterMultiplePets(String[] petNames) { for (int i = 0; i <
	 * petNames.length; i++) { String key = petNames[i]; VirtualPet pet =
	 * petMap.get(key); pet.water(); } }
	 */

	public void vetVisitMultiplePets(String[] petNames) {
		for (int i = 0; i < petNames.length; i++) {
			String key = petNames[i];
			VirtualPet pet = petMap.get(key);
			pet.vetVisit();
		}
	}

	// PET LIST METHODS ------------------------------

	public ArrayList<VirtualPet> getPetList() {
		Collection<VirtualPet> mapValues = petMap.values();
		ArrayList<VirtualPet> petList = new ArrayList<VirtualPet>(mapValues);
		return (petList);
	}

	public ArrayList<String[]> getPetStatsList() {
		ArrayList<VirtualPet> petList = getPetList();
		ArrayList<String[]> petStatsList = new ArrayList<String[]>();
		for (VirtualPet pet : petList) {
			petStatsList.add(pet.getStats());
		}
		return petStatsList;
	}

	public ArrayList<OrganicPet> getOrganicPetList() {
		Collection<VirtualPet> mapValues = petMap.values();
		ArrayList<OrganicPet> petList = new ArrayList<OrganicPet>();

		for (VirtualPet pet : mapValues) {
			if (pet instanceof OrganicPet) {
				petList.add((OrganicPet) pet);
			}
		}
		return petList;
	}

	public ArrayList<String[]> getOrganicePetStatsList() {
		ArrayList<OrganicPet> petList = getOrganicPetList();
		ArrayList<String[]> petStatsList = new ArrayList<String[]>();
		for (VirtualPet pet : petList) {
			petStatsList.add(pet.getStats());
		}
		return petStatsList;
	}

	public ArrayList<RobotPet> getRobotPetList() {
		Collection<VirtualPet> mapValues = petMap.values();
		ArrayList<RobotPet> petList = new ArrayList<RobotPet>();

		for (VirtualPet pet : mapValues) {
			if (pet instanceof RobotPet) {
				petList.add((RobotPet) pet);
			}
		}
		return petList;
	}

	public ArrayList<String[]> getRobotPetStatsList() {
		ArrayList<RobotPet> petList = getRobotPetList();
		ArrayList<String[]> petStatsList = new ArrayList<String[]>();
		for (VirtualPet pet : petList) {
			petStatsList.add(pet.getStats());
		}
		return petStatsList;
	}

}
