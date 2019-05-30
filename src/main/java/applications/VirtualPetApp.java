package applications;

import java.util.ArrayList;

import models.VirtualShelter;
import organicpets.OrganicCat;
import organicpets.OrganicDog;
import organicpets.OrganicPet;
import robotpets.RobotCat;
import robotpets.RobotDog;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualShelter virtualShelter = new VirtualShelter();

		virtualShelter.addPet(new OrganicCat("Mittens"));
		virtualShelter.addPet(new OrganicDog("Jeff"));
		virtualShelter.addPet(new RobotDog("Kujo"));
		virtualShelter.addPet(new RobotCat("Whiskers"));

		String[] columnLabels = OrganicPet.getFieldLabels();
		ArrayList<String[]> petStatsList = virtualShelter.getOrganicePetStatsList();

		String table = TextTableFactory.createTable(columnLabels, petStatsList);

		System.out.println(table);

	}
}
