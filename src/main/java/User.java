
public class User {
	private VirtualPet currentPet;
	
	public User() {
		currentPet = null;
	}

	public void setCurrentPet(VirtualPet currentPet) {
		this.currentPet = currentPet;
	}

	public VirtualPet getCurrentPet() {
		return currentPet;
	}

}
