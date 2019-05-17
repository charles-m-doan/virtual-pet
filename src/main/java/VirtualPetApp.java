import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome Ranger");
		String type = promptUserForPetType(input);
		if (type.equals("1")) {
			System.out.println("Please name your Dog");
			String name = promptUserForPetName(input);
		} else {
			System.out.println("Type not recognized");
		}

	}

	public static String promptUserForPetType(Scanner input) {
		System.out.println("Pet Type?");
		System.out.println("Press 1 for Dog");
		String response = input.nextLine();
		return response;

	}

	public static String promptUserForPetName(Scanner input) {
		System.out.println("Pet Name?");
		String response = input.nextLine();
		return response;

	}

}
