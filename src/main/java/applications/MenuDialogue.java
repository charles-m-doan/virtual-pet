package applications;

import java.util.Scanner;

public class MenuDialogue {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	private static final String MENU_FRAME = "---------------------------------------";
	private static final String MENU_HEADER_MESSAGE = "Please enter the number of a command...";
	private static final String INVALID_MENU_COMMAND_MESSAGE = "Invalid command.";
	private static final String DEFAULT_MENU_PROMPT = "Input: ";

	public final String title;
	public final String[] menuOptions;
	public final String menuDisplay;

	private String userInput = null;
	private int command = -1;
	private boolean validCommand = false;
	private Scanner input = new Scanner(System.in);

	public MenuDialogue(String[] menuOptions) {
		this.title = null;
		this.menuOptions = menuOptions;
		this.menuDisplay = assembleMenuDisplay();
	}

	public MenuDialogue(String title, String[] menuOptions) {
		this.title = title;
		this.menuOptions = menuOptions;
		this.menuDisplay = assembleMenuDisplay();
	}

	public void reset() {
		userInput = null;
		command = -1;
		validCommand = false;
	}

	public void showDialogue() {
		boolean continueDialogue = true;
		while (continueDialogue == true) {
			System.out.println(menuDisplay);
			userInput = promptUserInput(DEFAULT_MENU_PROMPT);
			try {
				command = Integer.parseInt(userInput) - 1;
				if (command >= 0 && command <= menuOptions.length - 1) {
					validCommand = true;
					continueDialogue = false;
				} else {
					throw new Exception();
				}
			} catch (Exception ex) {
				System.out.println(LINE_SEPARATOR + "\"" + userInput + "\"" + " is an invalid command.");
			}
		}
	}

	private String promptUserInput(String prompt) {
		System.out.print(prompt);
		String userInput = input.nextLine();
		return userInput;
	}

	private String assembleMenuDisplay() {
		StringBuilder optionsDisplay = new StringBuilder();
		optionsDisplay.append(MENU_FRAME + LINE_SEPARATOR);
		if (title != null) {
			optionsDisplay.append(title + LINE_SEPARATOR);
		}
		optionsDisplay.append(MENU_HEADER_MESSAGE + LINE_SEPARATOR);
		optionsDisplay.append(MENU_FRAME + LINE_SEPARATOR);
		for (int i = 0; i < menuOptions.length; i++) {
			int menuIndex = i + 1;
			if (menuIndex < 10 && menuOptions.length >= 10) {
				optionsDisplay.append("0");
			}
			optionsDisplay.append(menuIndex);
			optionsDisplay.append(") ");
			optionsDisplay.append(menuOptions[i]);

			if (i < menuOptions.length - 1) {
				optionsDisplay.append(LINE_SEPARATOR);
			}
		}
		optionsDisplay.append(LINE_SEPARATOR + MENU_FRAME);
		return optionsDisplay.toString();
	}

	public int getCommand() {
		return command;
	}

	public boolean commandIsValid() {
		return validCommand;
	}

	public String getUserInput() {
		return userInput;
	}
}
