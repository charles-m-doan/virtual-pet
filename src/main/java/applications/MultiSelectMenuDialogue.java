package applications;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiSelectMenuDialogue {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String PARSE_TOKEN = ",";

	private static final String MENU_FRAME = "------------------------------------------------------------------";
	private static final String MENU_HEADER_MESSAGE = "Please enter one or more item numbers as a comma-separated list...";
	private static final String INVALID_MENU_COMMAND_MESSAGE = "One or more items entered are invalid.";
	private static final String DEFAULT_MENU_PROMPT = "Input: ";

	public final String title;
	public final String[] selectableOptions;
	public final String menuDisplay;
	private final String[] menuOptions;

	private String userInput = null;
	private String[] itemsSelected = {};
	private Scanner input = new Scanner(System.in);

	public MultiSelectMenuDialogue(String title, String[] selectableOptions) {
		this.title = title;
		this.selectableOptions = selectableOptions;
		this.menuOptions = generateMenuOptions();
		this.menuDisplay = assembleMenuDisplay();
	}

	public void showDialogue() {
		boolean continueDialogue = true;
		while (continueDialogue == true) {
			System.out.println(menuDisplay);
			userInput = promptUserInput(DEFAULT_MENU_PROMPT);
			try {
				int[] selections = parseUserInputToIntegerSelections(userInput);

				for (int i = 0; i < selections.length; i++) {
					System.out.println(selections[i]);
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

	private void branchSelections(int[] selections) throws Exception {
		if (selections == null || selections.length <= 0) {
			throw new Exception();
		}
		if (selections.length == 1) {

			if (selections[0] == 1) {
				// CANCEL
				itemsSelected = null;
			} else if (selections[0] == 2) {
				// ALL
				
			} else {
				// SINGLE OPTION

			}
		}
	}

	private int[] parseUserInputToIntegerSelections(String userInput) throws Exception {
		if (userInput == null || userInput.isEmpty()) {
			int[] cancellation = { 1 };
			return cancellation;
		}
		ArrayList<Integer> selectionList = new ArrayList<Integer>();
		userInput = userInput.trim();
		String[] selections = userInput.split(PARSE_TOKEN);

		for (int i = 0; i < selections.length; i++) {
			int selection = Integer.parseInt(selections[i]);
			selectionList.add(new Integer(selection));
		}

		int[] selectionIndices = new int[selectionList.size()];
		for (int i = 0; i < selectionIndices.length; i++) {
			selectionIndices[i] = selectionList.get(i).intValue();
		}
		return selectionIndices;
	}

	private String[] generateMenuOptions() {
		String[] options = new String[selectableOptions.length + 2];
		options[0] = "Cancel";
		options[1] = "All";
		for (int i = 0; i < selectableOptions.length; i++) {
			options[i + 2] = selectableOptions[i];
		}
		return options;
	}

	public String getUserInput() {
		return userInput;
	}
}
