package applications;

import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
import robotpets.RobotCat;
import robotpets.RobotDog;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualShelter vs = new VirtualShelter();
		vs.addPet(new OrganicCat("Mittens"));
		vs.addPet(new OrganicDog("Jeff"));
		vs.addPet(new RobotDog("Kujo"));
		vs.addPet(new RobotCat("Whiskers"));
		vs.addPet(new OrganicCat("Ninja"));
		vs.addPet(new OrganicDog("George"));
		vs.addPet(new OrganicCat("Zoey"));
		vs.addPet(new OrganicDog("Lassie"));
		vs.addPet(new OrganicCat("Furbs"));
		vs.addPet(new OrganicDog("PoopEater"));
		vs.addPet(new RobotDog("K-9"));
		vs.addPet(new RobotCat("Terminator"));
		AppInterface2 testInterface = new AppInterface2(vs);
		testInterface.startInterface();
		
//		OrganicDog dog = new OrganicDog("Bill");
//		System.out.println(dog);
//		String[] prefFoods = dog.getPreferredFoods();
//		
//		for(int i = 0; i < prefFoods.length; i++) {
//			System.out.println(prefFoods[i]);
//		}
//		
//		String selectedFood = prefFoods[0];
//		
//		dog.feed(selectedFood);
		
		
	}
}
