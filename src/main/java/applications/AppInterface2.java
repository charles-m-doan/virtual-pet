package applications;

import java.util.ArrayList;
import java.util.Scanner;

import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;

public class AppInterface2 {

	// CONSTANTS
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String PET_NAME_PARSE_TOKEN = ",";

	// GENERAL MESSAGES
	private static final String WELCOME_MESSAGE = "Welcome to the Virtual Pet App!\n";
	private static final String EXIT_MESSAGE = LINE_SEPARATOR + LINE_SEPARATOR + "Thanks for playing. Bye!";
	private static final String NO_PETS_IN_SHELTER = "There are currently no pets in the shelter.";

	// MENU RELATED
	private static final String MENU_FRAME = "---------------------------------------";
	private static final String MENU_HEADER_MESSAGE = "Please enter the number of a command...";
	private static final String INVALID_MENU_COMMAND_MESSAGE = "Invalid command.";
	private static final String DEFAULT_MENU_PROMPT = "Command: ";

	// MAIN MENU
	private static final String[] MAIN_MENU_OPTIONS = { "Quit", "Create Pet", "Feed Pets", "Water Pets",
			"Play With Pets", "Clean Cages", "Take Pets to Vet", "Oil Robot Pets", "Repair Robot Pets" };
	private static final String MAIN_MENU_DISPLAY = assembleMenuDisplay(MAIN_MENU_OPTIONS);

	// PET CREATION
	private static final String PET_TYPE_MENU_HEADER = "\nType of pet?";
	private static final String[] PET_TYPE_MENU_OPTIONS = { "Dog", "Cat", "Robo Dog", "Robo Cat", "Cancel" };
	private static final String PET_TYPE_MENU_DISPLAY = assembleMenuDisplay(PET_TYPE_MENU_OPTIONS);
	private static final String PET_NAME_PROMPT = "What will you name your new pet? : ";

	// INSTANCE VARIABLES
	private Scanner input;
	private VirtualShelter vs;
	private boolean continueRunning;

	public AppInterface2(VirtualShelter vs) {
		this.vs = vs;
		input = new Scanner(System.in);
		continueRunning = false;
	}

	public void startInterface() {
		continueRunning = true;
		System.out.println(WELCOME_MESSAGE);
		while (continueRunning == true) {
			System.out.println(MAIN_MENU_DISPLAY);
			vs.printPetStatusTables();
			String userResponse = getUserResponse(DEFAULT_MENU_PROMPT);
			String feedback = "";
			try {
				if (userResponse.equals("")) {
					vs.tickPets();
				}
				int command = Integer.parseInt(userResponse);
				feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
				vs.tickPets();

				if (command == 1) {
					// QUIT
					continueRunning = false;
				} else if (command == 2) {
					// CREATE PET
					int petType = getPetTypeChoiceFromUser();
					if (petType != -1) {
						String petName = getUserResponse(PET_NAME_PROMPT);

						if (vs.mapContainsPet(petName)) {
							throw new Exception("A pet by that name already exists!");
						}

						if (petType == 1) {
							vs.addPet(new OrganicDog(petName));
							feedback = "You created a " + PET_TYPE_MENU_OPTIONS[petType - 1] + " named \"" + petName
									+ "\" and placed it in the shelter.";
						} else if (petType == 2) {
							vs.addPet(new OrganicCat(petName));
							feedback = "You created a " + PET_TYPE_MENU_OPTIONS[petType - 1] + " named \"" + petName
									+ "\" and placed it in the shelter.";
						} else {
							feedback = "You Chose to create a " + PET_TYPE_MENU_OPTIONS[petType - 1] + " named \""
									+ petName + "\".";
						}
					}
				} else if (command == 3) {
					// FEED PETS
					String petListString = getUserResponse("Which pets do you want to feed?" + LINE_SEPARATOR
							+ "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR
							+ "Pets?:");
					ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);

					String selectedFood = getUserResponse("Enter the name of a food to feed them. Options are..."
							+ LINE_SEPARATOR + vs.getFoodOptions() + LINE_SEPARATOR + "Food?: ");
					if (petNameList.size() > 0) {
						vs.feedPets(petNameList, selectedFood.trim());
						feedback = "You fed " + selectedFood + " to the following pets:"
								+ petNameListToString(petNameList);
					} else {
						feedback = "You didn't feed any pets.";
					}
				} else if (command == 4) {
					// WATER PETS
					String petListString = getUserResponse("Which pets do you want to water?" + LINE_SEPARATOR
							+ "Enter the names of one more or pets as a comma-separated list." + LINE_SEPARATOR
							+ "Pets?:");
					ArrayList<String> petNameList = parseUserResponseToPetNameList(petListString);
					if (petNameList.size() > 0) {
						vs.waterPets(petNameList);
						feedback = "You Watered the following pets:" + petNameListToString(petNameList);
					} else {
						feedback = "You didn't water any pets.";
					}
				} else if (command == 5) {
					// PLAY WITH PETS
				} else if (command == 6) {
					// CLEAN CAGES
				} else if (command == 7) {
					// TAKE PETS TO VET
				} else if (command == 8) {
					// OIL ROBOT PETS
				} else if (command == 9) {
					// REPAIR ROBOT PETS
				} else {
					throw new Exception();
				}
			} catch (Exception ex) {
				feedback = INVALID_MENU_COMMAND_MESSAGE + LINE_SEPARATOR + ex.getMessage();
			}

			System.out.println("\n");
			System.out.println(feedback);
			System.out.println("\n");
		}
		input.close();
		System.out.println(EXIT_MESSAGE);
		System.exit(0);
	}

	private int getPetTypeChoiceFromUser() {
		boolean continueMenuDialogue = true;
		while (continueMenuDialogue == true) {
			System.out.println(PET_TYPE_MENU_HEADER);
			System.out.println(PET_TYPE_MENU_DISPLAY);
			String userResponse = getUserResponse(DEFAULT_MENU_PROMPT);
			try {
				int command = Integer.parseInt(userResponse);

				if (command >= 1 && command <= PET_TYPE_MENU_OPTIONS.length) {
					return command;
				} else if (command == 5) {
					System.out.println(LINE_SEPARATOR + "Cancelling..." + LINE_SEPARATOR);
					return -1;
				} else {
					throw new Exception();
				}
			} catch (Exception ex) {
				System.out.println(
						"\n\"" + userResponse + "\"" + " is an invalid command.\n" + INVALID_MENU_COMMAND_MESSAGE);
			}
		}
		return -1;
	}

	private ArrayList<String> parseUserResponseToPetNameList(String userResponse) {
		ArrayList<String> petNameList = new ArrayList<String>();

		userResponse = userResponse.trim();
		String[] petNames = userResponse.split(PET_NAME_PARSE_TOKEN);

		for (String petName : petNames) {
			petName = petName.trim();
			if (petName.length() > 0 && vs.mapContainsPet(petName)) {
				petNameList.add(petName);
			} else {
				System.out.println(LINE_SEPARATOR + "\"" + petName + "\" not found in shelter.");
			}
		}
		return petNameList;
	}

	private String getUserResponse(String prompt) {
		System.out.print(prompt);
		String userResponse = input.nextLine();
		return userResponse;
	}

	private static String assembleMenuDisplay(String[] menuOptions) {
		StringBuilder optionsDisplay = new StringBuilder();
		optionsDisplay.append(MENU_FRAME + "\n");
		optionsDisplay.append(MENU_HEADER_MESSAGE + "\n");
		optionsDisplay.append(MENU_FRAME + "\n");
		for (int i = 0; i < menuOptions.length; i++) {
			int menuIndex = i + 1;
			if (menuIndex < 10) {
				optionsDisplay.append("0");
			}

			optionsDisplay.append(menuIndex);
			optionsDisplay.append(") ");
			optionsDisplay.append(menuOptions[i]);

			if (i < menuOptions.length - 1) {
				optionsDisplay.append("\n");
			}
		}
		optionsDisplay.append("\n" + MENU_FRAME);
		return optionsDisplay.toString();
	}

	private static void printPetNameList(ArrayList<String> petNames) {
		for (String petName : petNames) {
			System.out.println(petName);
		}
	}

	private static String petNameListToString(ArrayList<String> petNameList) {
		StringBuilder sb = new StringBuilder();
		for (String petName : petNameList) {
			sb.append(LINE_SEPARATOR + petName);
		}
		return sb.toString();
	}

}
