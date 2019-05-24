package organicpets;

import static org.junit.Assert.*;

import org.junit.Test;

import organicpets.OrganicDog;
import organicpets.OrganicPet;

public class OrganicPetTest {
	
	@Test
	public void petWillSoilBetween2And5Ticks() {
		OrganicPet underTest = new OrganicDog ("Jeff");
		System.out.println("Test");
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		assertTrue(underTest.isSoiled());
		
		
	}

}
