package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import applications.GlobalHelpers;
import organicpets.OrganicPet;
import robotpets.RobotPet;

public class VirtualShelter {

	private HashMap<String, VirtualPet> petMap;

	public VirtualShelter()
		{
		petMap = new HashMap<String, VirtualPet>();
		}

	public int getNumberOfPets()
		{
		int numberOfPets = petMap.size();
		return numberOfPets;
		}

	public boolean containsPet(String petName)
		{
		boolean hasPet = petMap.containsKey(petName);
		return hasPet;
		}

	public void addPet(VirtualPet virtualPet)
		{
		petMap.put(virtualPet.getName(), virtualPet);
		}

	public void removePet(String petName)
		{
		petMap.remove(petName);
		}

	public void tickPets()
		{
		Collection<VirtualPet> pets = petMap.values();
		for (VirtualPet pet : pets)
			{
			if (pet.getHealth() <= 0)
				{

				Random random = new Random();
				int value = random.nextInt(10);
				if (value < 3)
					{
					removePet(pet.getName());
					System.out.println(GlobalHelpers.LINE_SEPARATOR + "*" + pet.getName() + " the " + pet.getType() + " died from neglect.*" + GlobalHelpers.LINE_SEPARATOR);
					}
				else
					{
					System.out.println(GlobalHelpers.LINE_SEPARATOR + "**Warning: " + pet.getName() + " the " + pet.getType() + " is feeling terrible and is on the verge of death!**" + GlobalHelpers.LINE_SEPARATOR);
					}
				}
			}
		pets = petMap.values();
		for (VirtualPet pet : pets)
			{
			pet.tick();
			}
		}

	// Pet Manipulation Methods
	// =======================================================================

	public void restorePet(String petName) throws Exception
		{
		VirtualPet pet = petMap.get(petName);
		if (pet != null)
			{
			pet.restoreHealth();
			}
		else
			{
			throw new Exception("No pet named " + petName + " found.");
			}
		}

	public void playWithPet(String petName) throws Exception
		{
		VirtualPet pet = petMap.get(petName);
		if (pet != null)
			{
			pet.play();
			}
		else
			{
			throw new Exception("No pet named " + petName + " found.");
			}
		}

	public void walkPet(String petName) throws Exception
		{
		VirtualPet pet = petMap.get(petName);
		if (pet != null)
			{
			pet.walk();
			}
		else
			{
			throw new Exception("No pet named " + petName + " found.");
			}
		}

	// Applies only to OrganicPet ------------------------------

	public void feedPet(String petName, String selectedFood) throws Exception
		{
		VirtualPet pet = petMap.get(petName);
		if (pet != null)
			{
			if (pet instanceof OrganicPet)
				{
				((OrganicPet) pet).feed(selectedFood);
				}
			else
				{
				throw new Exception("You can't feed " + selectedFood + " to " + petName + " because it is not an OrganicPet!");
				}
			}
		else
			{
			throw new Exception("No pet named " + petName + " found.");
			}
		}

	public void waterPet(String petName) throws Exception
		{
		VirtualPet pet = petMap.get(petName);
		if (pet != null)
			{
			if (pet instanceof OrganicPet)
				{
				((OrganicPet) pet).water();
				}
			else
				{
				throw new Exception("You can't water " + petName + " because it is not an OrganicPet!");
				}
			}
		else
			{
			throw new Exception("No pet named " + petName + " found.");
			}
		}

	public void cleanCageOfPet(String petName) throws Exception
		{
		VirtualPet pet = petMap.get(petName);
		if (pet != null)
			{
			if (pet instanceof OrganicPet)
				{
				((OrganicPet) pet).cleanCage();
				}
			else
				{
				throw new Exception(petName + "'s cage doesn't need cleaning because it is not an OrganicPet!");
				}
			}
		else
			{
			throw new Exception("No pet named " + petName + " found.");
			}
		}

	// Applies only to RobotPet ------------------------------------

	public void oilPet(String petName) throws Exception
		{
		VirtualPet pet = petMap.get(petName);
		if (pet != null)
			{
			if (pet instanceof RobotPet)
				{
				((RobotPet) pet).fillOil();
				}
			else
				{
				throw new Exception(petName + "doesn't need oil because it is not a RobotPet!");
				}
			}
		else
			{
			throw new Exception("No pet named " + petName + " found.");
			}
		}

	// Multiple Pet Manipulation Methods ----------------------

	public void playWithPets(ArrayList<String> petNames) throws Exception
		{
		for (String petName : petNames)
			{
			playWithPet(petName);
			}
		}

	public void feedPets(ArrayList<String> petNames, String selectedFood) throws Exception
		{
		for (String petName : petNames)
			{
			feedPet(petName, selectedFood);
			}
		}

	public void waterPets(ArrayList<String> petNameList) throws Exception
		{
		for (String petName : petNameList)
			{
			waterPet(petName);
			}
		}

	public void walkPets(ArrayList<String> petNameList) throws Exception
		{
		for (String petName : petNameList)
			{
			walkPet(petName);
			}
		}

	public void oilPets(ArrayList<String> petNameList) throws Exception
		{
		for (String petName : petNameList)
			{
			oilPet(petName);
			}
		}

	public void cleanPetCages(ArrayList<String> petNameList) throws Exception
		{
		for (String petName : petNameList)
			{
			cleanCageOfPet(petName);
			}
		}

	public void repairPets(ArrayList<String> petNameList) throws Exception
		{
		for (String petName : petNameList)
			{
			VirtualPet pet = petMap.get(petName);
			if (pet != null && pet instanceof RobotPet)
				{
				restorePet(petName);
				}
			else
				{
				throw new Exception(petName + " can't be repaired because it is not a Robot. Take it to a vet!");
				}
			}
		}

	public void vetVisitPets(ArrayList<String> petNameList) throws Exception
		{
		for (String petName : petNameList)
			{
			VirtualPet pet = petMap.get(petName);
			if (pet != null && pet instanceof OrganicPet)
				{
				restorePet(petName);
				}
			else
				{
				throw new Exception(petName + " doesn't need to visit the vet because it is not an OrganicPet!");
				}
			}
		}

	public void maintainPets(ArrayList<String> petNames) throws Exception
		{
		for (String petName : petNames)
			{
			VirtualPet pet = petMap.get(petName);
			if (pet != null && pet instanceof RobotPet)
				{
				restorePet(petName);
				}
			else
				{
				throw new Exception(petName + " can't be repaired because it is not a RobotPet!");
				}
			}
		}

	// End Pet Manipulation Methods
	// =============================================================

	public String toString()
		{
		String returnString = "--Pets In Shelter--\n";
		for (String key : petMap.keySet())
			{
			VirtualPet pet = petMap.get(key);
			returnString += pet.toString() + "\n";
			}
		return returnString;
		}

	// PET LIST METHODS ------------------------------

	public String[] getOrganicPetNames()
		{
		ArrayList<OrganicPet> organicPetList = getOrganicPetList();
		ArrayList<String> petNameList = new ArrayList<String>(organicPetList.size());
		for (OrganicPet pet : organicPetList)
			{
			petNameList.add(pet.getName());
			}
		return (String[]) petNameList.toArray(new String[petNameList.size()]);
		}

	public String[] getRobotPetNames()
		{
		ArrayList<RobotPet> robotPetList = getRobotPetList();
		ArrayList<String> petNameList = new ArrayList<String>(robotPetList.size());
		for (RobotPet pet : robotPetList)
			{
			petNameList.add(pet.getName());
			}
		return (String[]) petNameList.toArray(new String[petNameList.size()]);
		}

	public String[] getAllPetNames()
		{
		ArrayList<VirtualPet> petList = getPetList();
		ArrayList<String> petNameList = new ArrayList<String>(petList.size());
		for (VirtualPet pet : petList)
			{
			petNameList.add(pet.getName());
			}
		return (String[]) petNameList.toArray(new String[petNameList.size()]);
		}

	public String[] getAllPetNames2()
		{
		Set<String> keys = petMap.keySet();
		ArrayList<String> petNameList = new ArrayList<String>(keys.size());
		String[] array = new String[keys.size()];
		for (String petName : keys)
			{
			petNameList.add(petName);
			}

		for (int i = 0; i < keys.size(); i++)
			{
			array[i] = petNameList.get(i);
			}
		return array;
		}

	public String[] petListToNameArray(ArrayList<VirtualPet> petList)
		{
		ArrayList<String> petNameList = new ArrayList<String>(petList.size());
		for (VirtualPet pet : petList)
			{
			petNameList.add(pet.getName());
			}
		return (String[]) petNameList.toArray(new String[petNameList.size()]);
		}

	public ArrayList<VirtualPet> getPetList()
		{
		Collection<VirtualPet> mapValues = petMap.values();
		ArrayList<VirtualPet> petList = new ArrayList<VirtualPet>(mapValues);
		return (petList);
		}

	public ArrayList<OrganicPet> getOrganicPetList()
		{
		Collection<VirtualPet> mapValues = petMap.values();
		ArrayList<OrganicPet> petList = new ArrayList<OrganicPet>();

		for (VirtualPet pet : mapValues)
			{
			if (pet instanceof OrganicPet)
				{
				petList.add((OrganicPet) pet);
				}
			}
		return petList;
		}

	public ArrayList<RobotPet> getRobotPetList()
		{
		Collection<VirtualPet> mapValues = petMap.values();
		ArrayList<RobotPet> petList = new ArrayList<RobotPet>();

		for (VirtualPet pet : mapValues)
			{
			if (pet instanceof RobotPet)
				{
				petList.add((RobotPet) pet);
				}
			}
		return petList;
		}

	public ArrayList<String[]> getPetStatsList()
		{
		ArrayList<VirtualPet> petList = getPetList();
		ArrayList<String[]> petStatsList = new ArrayList<String[]>();
		for (VirtualPet pet : petList)
			{
			petStatsList.add(pet.getStats());
			}
		return petStatsList;
		}

	public ArrayList<String[]> getOrganicPetStatsList()
		{
		ArrayList<OrganicPet> petList = getOrganicPetList();
		ArrayList<String[]> petStatsList = new ArrayList<String[]>();
		for (VirtualPet pet : petList)
			{
			petStatsList.add(pet.getStats());
			}
		return petStatsList;
		}

	public ArrayList<String[]> getRobotPetStatsList()
		{
		ArrayList<RobotPet> petList = getRobotPetList();
		ArrayList<String[]> petStatsList = new ArrayList<String[]>();
		for (VirtualPet pet : petList)
			{
			petStatsList.add(pet.getStats());
			}
		return petStatsList;
		}

}
