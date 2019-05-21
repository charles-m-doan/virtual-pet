import java.util.HashMap;

public class VirtualShelter {

	private HashMap<String, VirtualPet>  petMap; 
	
	public VirtualShelter() {
		petMap= new HashMap<String, VirtualPet>();
		
	}

	public int getNumberOfPets() {
		int numberOfPets= petMap.size();
		return numberOfPets;
	}
}
