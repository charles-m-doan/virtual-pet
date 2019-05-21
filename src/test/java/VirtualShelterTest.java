import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class VirtualShelterTest {
	
	public VirtualShelterTest() {
	
	
		
	}
	@Test
	public void virtualShelterShouldHave0Pets()  {
		int expectedNumberOfPets= 0;
		VirtualShelter testShelter= new VirtualShelter();
		int actualNumberOfPets= testShelter.getNumberOfPets();
		assertEquals(expectedNumberOfPets, actualNumberOfPets);
		
		
		
	}
}
