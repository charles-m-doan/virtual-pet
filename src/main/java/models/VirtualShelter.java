package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import applications.StatusTableFactory;
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

	public void removePet(String petName) {
		petMap.remove(petName);
	}

	public void tickPets() {
		Collection<VirtualPet> pets = petMap.values();
		for (VirtualPet pet : pets) {
			pet.tick();
		}
	}

	// Pet Manipulation Methods
	// ======================================================

	// Single Pet Manipulation Methods --------------------------

	// Applies to VirtualPet and all descendants

	public void restorePet(String petName) {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			pet.restoreHealth();
		} else {
			System.out.println("No pet named " + petName + " found.");
		}
	}

	public void playWithPet(String petName) {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			pet.play();
		} else {
			System.out.println("No pet named " + petName + " found.");
		}
	}

	public void walkPet(String petName) {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			pet.walk();
		} else {
			System.out.println("No pet named " + petName + " found.");
		}
	}

	// Applies only to OrganicPet ------------------------------

	public void feedPet(String petName, String selectedFood) {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).feed(selectedFood);
			} else {
				System.out.println("You can't feed " + selectedFood + " to " + petName + " because it is not an OrganicPet!");
			}
		} else {
			System.out.println("No pet named " + petName + " found.");
		}
	}

	public void waterPet(String petName) {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).water();
			} else {
				System.out.println("You can't water " + petName + " because it is not an OrganicPet!");
			}
		} else {
			System.out.println("No pet named " + petName + " found.");
		}
	}

	public void cleanCageOfPet(String petName) {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).cleanCage();
			} else {
				System.out.println(petName + "'s cage doesn't need cleaning because it is not an OrganicPet!");
			}
		} else {
			System.out.println("No pet named " + petName + " found.");
		}
	}

	// Applies only to RobotPet ------------------------------------

	public void fillOilOfPet(String petName) {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof RobotPet) {
				((RobotPet) pet).fillOil();
			} else {
				System.out.println(petName + "doesn't need oil because it is not a RobotPet!");
			}
		} else {
			System.out.println("No pet named " + petName + " found.");
		}
	}

	// Multiple Pet Manipulation Methods ----------------------

	public void playWithPets(ArrayList<String> petNames) {
		for (String petName : petNames) {
			playWithPet(petName);
		}
	}

	public void vetVisitPets(ArrayList<String> petNames) {
		for (String petName : petNames) {
			VirtualPet pet = petMap.get(petName);
			if (pet != null && pet instanceof OrganicPet) {
				restorePet(petName);
			} else {
				System.out.println(petName + " doesn't need to visit the vet because it is not an OrganicPet!");
			}
		}
	}

	public void maintainPets(ArrayList<String> petNames) {
		for (String petName : petNames) {
			VirtualPet pet = petMap.get(petName);
			if (pet != null && pet instanceof RobotPet) {
				restorePet(petName);
			} else {
				System.out.println(petName + " can't be repaired because it is not a RobotPet!");
			}
		}
	}

	// End Pet Manipulation Methods
	// =============================================================

	public String toString() {
		String returnString = "--Pets In Shelter--\n";
		for (String key : petMap.keySet()) {
			VirtualPet pet = petMap.get(key);
			returnString += pet.toString() + "\n";
		}
		return returnString;
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

	public ArrayList<String[]> getOrganicPetStatsList() {
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

	public void printPetStatusTables() {
		System.out.println(StatusTableFactory.generateStatusTableForRobotPets(this));
		System.out.println(StatusTableFactory.generateStatusTableForOrganicPets(this));
	}

}
