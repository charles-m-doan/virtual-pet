import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome Ranger");

		String name = "";
		String type = "";

		type = promptUserForPetType(input);
		if (type.equals("1")) {
			System.out.println("Please name your Dog");
			name = promptUserForPetName(input);
		} else if (type.equals("2")) {
			System.out.println("Please name your Cat");
			name = promptUserForPetName(input);
		} else {
			System.out.println("Type not recognized");
		}

		VirtualPet pet1 = new VirtualPet(name);
		System.out.println(pet1.getType() + " : " + pet1.getName());

		VirtualPet pet2 = new VirtualPet("Bill");
		System.out.println(pet2.getType() + " : " + pet2.getName());
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
