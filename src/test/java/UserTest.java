import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserTest {
	User testUser1 = new User();
	VirtualPet testPet1 = new VirtualPet("Dog","Bill");

	public UserTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void currentPetForNewUserShouldBeNull() {
		assertTrue(testUser1.getCurrentPet() == null);
	}
	
	@Test
	public void userShouldHaveCurrentPetWithNameBill() {
		testUser1.setCurrentPet(testPet1);
		String expectedName = "Bill";
		String actualName = testUser1.getCurrentPet().getName();
		assertEquals(expectedName, actualName);		
	}
	
	
}
