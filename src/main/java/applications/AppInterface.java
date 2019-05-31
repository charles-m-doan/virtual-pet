package applications;

import java.util.ArrayList;
import java.util.Scanner;

import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
import robotpets.RobotCat;
import robotpets.RobotDog;

public class AppInterface {

	// CONSTANTS
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String PET_NAME_PARSE_TOKEN = ",";

	// GENERAL MESSAGES
	private static final String WELCOME_MESSAGE = "Welcome to the Virtual Pet App!\n";
	private static final String EXIT_MESSAGE = LINE_SEPARATOR + LINE_SEPARATOR + "Thanks for playing. Bye!";
	// private static final String NO_PETS_IN_SHELTER = "There are currently no pets in the shelter.";

	// MENU RELATED
	// private static final String MENU_FRAME = "---------------------------------------";
	// private static final String MENU_HEADER_MESSAGE = "Please enter the number of a command...";
	private static final String INVALID_MENU_COMMAND_MESSAGE = "Invalid command.";
	// private static final String DEFAULT_MENU_PROMPT = "Input: ";

	// MAIN MENU
	private static final String[] MAIN_MENU_OPTIONS = { "Tick Pets", "Create Pet", "Release Pet", "Feed Pets", "Water Pets", "Play With Pets", "Walk Pets", "Clean Cages", "Take Pets to Vet", "Oil Robot Pets", "Repair Robot Pets", "Quit" };
	// private static final String MAIN_MENU_DISPLAY = assembleMenuDisplay(MAIN_MENU_OPTIONS);

	// PET CREATION
	private static final String PET_TYPE_MENU_TITLE = "Type of pet?";
	private static final String[] PET_TYPE_MENU_OPTIONS = { "Dog", "Cat", "Robot Dog", "Robot Cat", "Cancel" };
	// private static final String PET_TYPE_MENU_DISPLAY = assembleMenuDisplay(PET_TYPE_MENU_OPTIONS);
	// private static final String PET_NAME_PROMPT = "What will you name your new pet? : ";

	// PET FEEDING
	// private static final String FOOD_MENU_TITLE = LINE_SEPARATOR + "Type of food?";
	// private static final String[] FOOD_MENU_OPTIONS = getFoodOptions();
	// private static final String FOOD_MENU_DISPLAY = assembleMenuDisplay(FOOD_MENU_OPTIONS);
	// private static final String FOOD_PROMPT = "Food Choice: ";

	// INSTANCE VARIABLES
	private Scanner input;
	private VirtualShelter vs;
	private boolean continueRunning;

	public AppInterface(VirtualShelter vs)
		{
		this.vs = vs;
		input = new Scanner(System.in);
		continueRunning = false;
		}

	public void startInterface()
		{
		continueRunning = true;
		System.out.println(WELCOME_MESSAGE);
		MenuDialogue mainMD = new MenuDialogue(MAIN_MENU_OPTIONS);

		while (continueRunning == true)
			{
			System.out.println(StatusTableFactory.generateStatusTableForVirtualPets(vs));
			mainMD.reset();
			mainMD.showDialogue();
			if (mainMD.commandIsValid())
				{
				try
					{
					branchMainCommandChoices(mainMD.getCommand());
					}
				catch (NumberFormatException nfex)
					{
					System.out.println(INVALID_MENU_COMMAND_MESSAGE);
					}
				catch (Exception ex)
					{
					System.out.println(ex.getMessage());
					}
				}
			}
		input.close();
		System.out.println(EXIT_MESSAGE);
		System.exit(0);
		}

	private String branchMainCommandChoices(int command) throws Exception
		{
		System.out.println("You chose: " + MAIN_MENU_OPTIONS[command]);
		switch (command)
			{
			case 0:
				// TICK PETS
				vs.tickPets();
				break;
			case 1:
				// CREATE PET
				petCreation();
				break;

			case 2:
				// RELEASE PET
				petRelease();
				break;

			case 3:
				// FEED PETS
				petFeeding();
				break;

			case 4:
				// WATER PETS
				petWatering();
				break;

			case 5:
				// PLAY WITH PETS
				petPlaying();
				break;

			case 6:
				// WALK PETS
				petWalking();
				break;

			case 7:
				// CLEAN CAGES
				petCageCleaning();
				break;

			case 8:
				// TAKE PETS TO VET
				petVetVisiting();
				break;

			case 9:
				// OIL ROBOT PETS
				petOiling();
				break;

			case 10:
				// REPAIR ROBOT PETS
				petRepairing();
				break;

			case 11:
				// QUIT
				continueRunning = false;
				break;

			default:
				throw new Exception(INVALID_MENU_COMMAND_MESSAGE);
			}
		return null;
		}

	// COMMAND BRANCH METHODS ----------------------------------------------------------

	private void petCreation() throws Exception
		{
		MenuDialogue petTypeMD = new MenuDialogue(PET_TYPE_MENU_TITLE, PET_TYPE_MENU_OPTIONS);
		petTypeMD.showDialogue();
		if (petTypeMD.commandIsValid())
			{
			try
				{
				String petName = "";
				int command = petTypeMD.getCommand();
				switch (command)
					{
					case 0:
						petName = promptUserInput("What will you name this " + PET_TYPE_MENU_OPTIONS[command] + "? :");
						vs.addPet(new OrganicDog(petName));
						System.out.println("You created a " + PET_TYPE_MENU_OPTIONS[command] + " named \"" + petName + "\" and placed it in the shelter.");
						break;
					case 1:
						petName = promptUserInput("What will you name this " + PET_TYPE_MENU_OPTIONS[command] + "? :");
						vs.addPet(new OrganicCat(petName));
						System.out.println("You created a " + PET_TYPE_MENU_OPTIONS[command] + " named \"" + petName + "\" and placed it in the shelter.");
						break;
					case 2:
						petName = promptUserInput("What will you name this " + PET_TYPE_MENU_OPTIONS[command] + "? :");
						vs.addPet(new RobotDog(petName));
						System.out.println("You created a " + PET_TYPE_MENU_OPTIONS[command] + " named \"" + petName + "\" and placed it in the shelter.");
						break;
					case 3:
						petName = promptUserInput("What will you name this " + PET_TYPE_MENU_OPTIONS[command] + "? :");
						vs.addPet(new RobotCat(petName));
						System.out.println("You created a " + PET_TYPE_MENU_OPTIONS[command] + " named \"" + petName + "\" and placed it in the shelter.");
						break;
					case 4:
						break;
					default:
					}
				}
			catch (NumberFormatException nfex)
				{
				System.out.println(INVALID_MENU_COMMAND_MESSAGE);
				}
			catch (Exception ex)
				{
				System.out.println(ex.getMessage());
				}
			}
		}

	private void petRelease() throws Exception
		{
		String[] petNames = vs.getPetNames();
		String[] options = new String[petNames.length + 1];
		options[0] = "Cancel";
		for (int i = 0; i < petNames.length; i++)
			{
			options[i + 1] = petNames[i];
			}
		MenuDialogue petReleaseMD = new MenuDialogue("Release a Pet?", options);
		petReleaseMD.showDialogue();
		int command = petReleaseMD.getCommand();
		switch (command)
			{
			case 0:
				// User Chose Cancel
				break;
			default:
				String petName = options[command];
				vs.removePet(petName);
				System.out.println("You released " + petName + " from the shelter.");
			}
		}

	private void petFeeding() throws Exception
		{
		String petListString = promptUserInput("Which pets do you want to feed?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);

		String[] foodOptions = getFoodOptions();
		String[] options = new String[foodOptions.length + 1];
		options[0] = "Cancel";
		for (int i = 0; i < foodOptions.length; i++)
			{
			options[i + 1] = foodOptions[i];
			}
		MenuDialogue foodMD = new MenuDialogue("What will you use for feed?", options);
		foodMD.showDialogue();

		int command = foodMD.getCommand();
		switch (command)
			{
			case 0:
				// User Chose Cancel
				break;
			default:
				String selectedFood = options[command];
				if (petNameList.size() > 0)
					{
					vs.feedPets(petNameList, selectedFood);
					System.out.println("You fed " + selectedFood + " to the following pets:" + GlobalHelpers.stringArrayListToString(petNameList));
					}
				else
					{
					System.out.println("You didn't feed any pets.");
					}
			}
		}

	private void petWatering() throws Exception
		{
		String petListString = promptUserInput("Which pets do you want to water?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
		if (petNameList.size() > 0)
			{
			vs.waterPets(petNameList);
			System.out.println("You watered the following pets:" + GlobalHelpers.stringArrayListToString(petNameList));
			}
		else
			{
			System.out.println("You didn't water any pets.");
			}
		}

	private void petPlaying() throws Exception
		{
		String petListString = promptUserInput("Which pets do you want to play with?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
		if (petNameList.size() > 0)
			{
			vs.playWithPets(petNameList);
			System.out.println("You played with the following pets:" + GlobalHelpers.stringArrayListToString(petNameList));
			}
		else
			{
			System.out.println("You didn't play with any pets.");
			}
		}

	private void petWalking() throws Exception
		{
		String petListString = promptUserInput("Which pets do you want to walk?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
		if (petNameList.size() > 0)
			{
			vs.walkPets(petNameList);
			System.out.println("You walked the following pets:" + GlobalHelpers.stringArrayListToString(petNameList));
			}
		else
			{
			System.out.println("You didn't walk any pets.");
			}
		}

	private void petCageCleaning() throws Exception
		{
		String petListString = promptUserInput("Which pet cages do you want to clean?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
		if (petNameList.size() > 0)
			{
			vs.cleanPetCages(petNameList);
			System.out.println("You the cages of the following pets:" + GlobalHelpers.stringArrayListToString(petNameList));
			}
		else
			{
			System.out.println("You didn't clean any cages.");
			}
		}

	private void petVetVisiting() throws Exception
		{
		String petListString = promptUserInput("Which pets do you want to take to the vet?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
		if (petNameList.size() > 0)
			{
			vs.vetVisitPets(petNameList);
			System.out.println("You took the following pets to the vet:" + GlobalHelpers.stringArrayListToString(petNameList));
			}
		else
			{
			System.out.println("You didn't take any pets to the vet.");
			}
		}

	private void petOiling() throws Exception
		{
		String petListString = promptUserInput("Which pets do you want to oil?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
		if (petNameList.size() > 0)
			{
			vs.oilPets(petNameList);
			System.out.println("You oiled the following pets:" + GlobalHelpers.stringArrayListToString(petNameList));
			}
		else
			{
			System.out.println("You didn't oil any pets.");
			}
		}

	private void petRepairing() throws Exception
		{
		String petListString = promptUserInput("Which pets do you want to repair?" + LINE_SEPARATOR + "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR + "Pets?:");
		ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
		if (petNameList.size() > 0)
			{
			vs.repairPets(petNameList);
			System.out.println("You repaired the following pets:" + GlobalHelpers.stringArrayListToString(petNameList));
			}
		else
			{
			System.out.println("You didn't repair any pets.");
			}
		}

	private ArrayList<String> parseUserResponseToPetNameList(String userResponse)
		{
		ArrayList<String> petNameList = new ArrayList<String>();

		userResponse = userResponse.trim();
		String[] petNames = userResponse.split(PET_NAME_PARSE_TOKEN);

		for (String petName : petNames)
			{
			petName = petName.trim();
			if (petName.length() > 0 && vs.containsPet(petName))
				{
				petNameList.add(petName);
				}
			else
				{
				System.out.println(LINE_SEPARATOR + "\"" + petName + "\" not found in shelter.");
				}
			}
		return petNameList;
		}

	private String promptUserInput(String prompt)
		{
		System.out.print(prompt);
		String userInput = input.nextLine();
		return userInput;
		}

	public static String[] getFoodOptions()
		{
		ArrayList<String> foodList = new ArrayList<String>();
		String[] catFoods = OrganicCat.getPreferredFoods();
		String[] dogFoods = OrganicDog.getPreferredFoods();
		for (String food : catFoods)
			{
			if (!foodList.contains(food))
				{
				foodList.add(food);
				}
			}
		for (String food : dogFoods)
			{
			if (!foodList.contains(food))
				{
				foodList.add(food);
				}
			}
		String[] foodArray = new String[foodList.size()];

		for (int i = 0; i < foodArray.length; i++)
			{
			foodArray[i] = foodList.get(i);
			}

		return foodArray;
		}
}
