package organicpets;

import static org.junit.Assert.*;

import org.junit.Test;

import organicpets.OrganicDog;
import organicpets.OrganicPet;

public class OrganicPetTest {
	OrganicPet underTest = new OrganicDog("Jeff");

	@Test
	public void petWillSoilBetween3And5Ticks() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		assertTrue(underTest.isSoiled());
	}

	@Test
	public void shouldResetSoilCounterAfterWalking() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.walk();
		assertTrue(underTest.getTicksUntilSoiled() >= 3);
	}

	@Test
	public void shouldTestCageIsClean() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.cleanCage();
		assertFalse(underTest.isSoiled());
	}
/*	@Test
	public void waterShouldFillByHalf() {
		int thirstExpected = underTest.getThirst()/2; 
		System.out.println(underTest.getThirst());
		underTest.tick();	
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();	
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		System.out.println(underTest.getThirst());
		underTest.water();
		System.out.println(underTest.getThirst());
		assertEquals(thirstExpected, underTest.getThirst());
	}
	*/
	@Test
	public void bordeomShouldIncrease() {
		System.out.println(underTest.getBoredom());
		underTest.tick();	
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();	
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int expectedBoredom = underTest.getBoredom();
		System.out.println(underTest.getBoredom());
		underTest.walk();
		System.out.println(underTest.getBoredom());
		assertTrue(underTest.getBoredom() >= expectedBoredom);
	}

//	@Test
//	public void shouldHaveFavoriteFood() {
//		assertEquals("dry dog food", underTest.getFavoriteFood());
		

//	}

}
