package organicpets;

import static org.junit.Assert.*;

import org.junit.Test;

import organicpets.OrganicDog;
import organicpets.OrganicPet;

public class OrganicPetTest {
	OrganicPet underTest = new OrganicDog("Jeff");

	@Test
	public void pet_will_soil_after_5_ticks() {
		underTest.setTicksUntilSoiled(5);
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

}
