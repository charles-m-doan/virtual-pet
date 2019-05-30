package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import applications.StatusTableFactory;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
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

	public boolean mapContainsPet(String petName) {
		boolean hasPet = petMap.containsKey(petName);
		return hasPet;
	}

	// Pet Manipulation Methods
	// ======================================================

	// Single Pet Manipulation Methods --------------------------

	// Applies to VirtualPet and all descendants

	public void restorePet(String petName) throws Exception {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			pet.restoreHealth();
		} else {
			throw new Exception("No pet named " + petName + " found.");
		}
	}

	public void playWithPet(String petName) throws Exception {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			pet.play();
		} else {
			throw new Exception("No pet named " + petName + " found.");
		}
	}

	public void walkPet(String petName) throws Exception {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			pet.walk();
		} else {
			throw new Exception("No pet named " + petName + " found.");
		}
	}

	// Applies only to OrganicPet ------------------------------

	public void feedPet(String petName, String selectedFood) throws Exception {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).feed(selectedFood);
			} else {
				throw new Exception(
						"You can't feed " + selectedFood + " to " + petName + " because it is not an OrganicPet!");
			}
		} else {
			throw new Exception("No pet named " + petName + " found.");
		}
	}

	public void waterPet(String petName) throws Exception {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).water();
			} else {
				throw new Exception("You can't water " + petName + " because it is not an OrganicPet!");
			}
		} else {
			throw new Exception("No pet named " + petName + " found.");
		}
	}

	public void cleanCageOfPet(String petName) throws Exception {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof OrganicPet) {
				((OrganicPet) pet).cleanCage();
			} else {
				throw new Exception(petName + "'s cage doesn't need cleaning because it is not an OrganicPet!");
			}
		} else {
			throw new Exception("No pet named " + petName + " found.");
		}
	}

	// Applies only to RobotPet ------------------------------------

	public void fillOilOfPet(String petName) throws Exception {
		VirtualPet pet = petMap.get(petName);
		if (pet != null) {
			if (pet instanceof RobotPet) {
				((RobotPet) pet).fillOil();
			} else {
				throw new Exception(petName + "doesn't need oil because it is not a RobotPet!");
			}
		} else {
			throw new Exception("No pet named " + petName + " found.");
		}
	}

	// Multiple Pet Manipulation Methods ----------------------

	public void playWithPets(ArrayList<String> petNames) throws Exception {
		for (String petName : petNames) {
			playWithPet(petName);
		}
	}

	public void feedPets(ArrayList<String> petNames, String selectedFood) throws Exception {
		for (String petName : petNames) {
			feedPet(petName, selectedFood);
		}
	}

	public void waterPets(ArrayList<String> petNameList) throws Exception {
		for (String petName : petNameList) {
			waterPet(petName);
		}
	}

	public void vetVisitPets(ArrayList<String> petNameList) throws Exception {
		for (String petName : petNameList) {
			VirtualPet pet = petMap.get(petName);
			if (pet != null && pet instanceof OrganicPet) {
				restorePet(petName);
			} else {
				throw new Exception(petName + " doesn't need to visit the vet because it is not an OrganicPet!");
			}
		}
	}

	public void maintainPets(ArrayList<String> petNames) throws Exception {
		for (String petName : petNames) {
			VirtualPet pet = petMap.get(petName);
			if (pet != null && pet instanceof RobotPet) {
				restorePet(petName);
			} else {
				throw new Exception(petName + " can't be repaired because it is not a RobotPet!");
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
		System.out.println(StatusTableFactory.generateStatusTableForVirtualPets(this));
		//System.out.println(StatusTableFactory.generateStatusTableForRobotPets(this));
		//System.out.println(StatusTableFactory.generateStatusTableForOrganicPets(this));
	}
	
	public String getFoodOptions() {
		ArrayList<String> foodList = new ArrayList<String>();
		String[] catFoods = OrganicCat.getPreferredFoods();
		String[] dogFoods = OrganicDog.getPreferredFoods();
		for(String food : catFoods) {
			if(!foodList.contains(food)) {
				foodList.add(food);
			}
		}
		for(String food : dogFoods) {
			if(!foodList.contains(food)) {
				foodList.add(food);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(String food : foodList) {
			sb.append(food + ", ");
		}
		return sb.toString();
	}

}
