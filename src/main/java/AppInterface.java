import java.util.Scanner;

public class AppInterface {

	// CONSTANTS

	// GENERAL MESSAGES
	private static final String WELCOME_MESSAGE = "Welcome to the Virtual Pet App!\n";
	private static final String EXIT_MESSAGE = "\n\n\nThanks for playing. Bye!";
	private static final String NO_PETS_IN_SHELTER = "There are currently no pets in the shelter.";
	private static final String NO_WORKING_PET = "You aren't currently working with any pet.";

	// MENU RELATED
	private static final String MENU_FRAME = "---------------------------------------";
	private static final String MENU_HEADER_MESSAGE = "Please enter the number of a command...";
	private static final String INVALID_MENU_COMMAND_MESSAGE = "Please enter only numbers corresponding to commands shown in the menu.";
	private static final String DEFAULT_MENU_PROMPT = "Command: ";

	// MAIN MENU
	private static final String[] MAIN_MENU_OPTIONS = { "Create a virtual pet.", "Play with current pet.",
			"Feed current pet.", "Water current pet.", "Place current pet in shelter.", "Take pet from shelter.",
			"See status of pets in shelter.", "Quit" };
	private static final String MAIN_MENU_DISPLAY = assembleMenuDisplay(MAIN_MENU_OPTIONS);

	// PET CREATION
	private static final String PET_TYPE_MENU_HEADER = "\nType of pet?";
	private static final String[] PET_TYPE_MENU_OPTIONS = { "Dog", "Cat", "Robo Dog", "Robo Cat", "Cancel" };
	private static final String PET_TYPE_MENU_DISPLAY = assembleMenuDisplay(PET_TYPE_MENU_OPTIONS);
	private static final String PET_NAME_PROMPT = "What will you name your new pet? : ";

	// INSTANCE VARIABLES
	private Scanner input;
	private boolean continueRunning;
	private VirtualShelter petShelter;

	public AppInterface(VirtualShelter petShelter) {
		this.petShelter = petShelter;
		input = new Scanner(System.in);
		continueRunning = false;
	}

	public void startInterface() {
		continueRunning = true;
		System.out.println(WELCOME_MESSAGE);
		while (continueRunning == true) {
			System.out.println(MAIN_MENU_DISPLAY);
			String userResponse = getUserResponse(DEFAULT_MENU_PROMPT);
			String feedback = "";
			try {

				int command = Integer.parseInt(userResponse);

				if (command == 1) {
					// feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
					int petType = getPetTypeChoiceFromUser();
					if (petType != -1) {
						String petName = getUserResponse(PET_NAME_PROMPT);

						if (petType == 2) {
							petShelter.addPet(new VirtualCat(petName));
							feedback = "You created a " + PET_TYPE_MENU_OPTIONS[petType - 1] + " named \"" + petName
									+ "\" and placed it in the shelter.";
						} else {
							feedback = "You Chose to create a " + PET_TYPE_MENU_OPTIONS[petType - 1] + " named \""
									+ petName + "\".";
						}
						// branch remaining pet types from here with additional if-else statements
					}
				} else if (command == 2) {
					feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
				} else if (command == 3) {
					feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
				} else if (command == 4) {
					feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
				} else if (command == 5) {
					feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
				} else if (command == 6) {
					feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
				} else if (command == 7) {
					feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
					if (petShelter.getNumberOfPets() <= 0) {
						feedback = NO_PETS_IN_SHELTER;
					} else {
						feedback = petShelter.toString();
					}
				} else if (command == 8) {
					feedback = "You Chose: \"" + MAIN_MENU_OPTIONS[command - 1] + "\"";
					continueRunning = false;
				} else {
					throw new Exception();
				}

			} catch (Exception ex) {
				feedback = "\"" + userResponse + "\"" + " is an invalid command.\n";
				feedback += INVALID_MENU_COMMAND_MESSAGE;
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

				if (command == 5) {
					System.out.println("\nCancelling...\n");
					return -1;
				} else if (command >= 1 && command <= PET_TYPE_MENU_OPTIONS.length) {
					return command;
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

}
