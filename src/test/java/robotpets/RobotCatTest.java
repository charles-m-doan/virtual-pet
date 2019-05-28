package robotpets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RobotCatTest {
	
	RobotPet underTest = new RobotCat("Mittens");

	public RobotCatTest() {
	}
	
	@Test
	public void shouldHave98OilAfter2Ticks() {
		underTest.tick();
		underTest.tick();
		assertEquals(98, underTest.getOil());
	}
	
	@Test
	public void shouldHave94OilAfter2Plays() {
		underTest.play();
		underTest.play();
		assertEquals(94, underTest.getOil());
	}
	
	@Test
	public void shouldHave96OilAfter2Walks() {
		underTest.walk();
		underTest.walk();
		assertEquals(96, underTest.getOil());
	}
	
	@Test
	public void shouldHave98HealthAfter2Ticks() {
		underTest.tick();
		underTest.tick();
		assertEquals(98, underTest.getHealth());
	}
	
	@Test
	public void shouldHave96HealthAfter2Plays() {
		underTest.play();
		underTest.play();
		assertEquals(96, underTest.getHealth());
	}
	
	@Test
	public void shouldHave94HealthAfter2Walks() {
		underTest.walk();
		underTest.walk();
		assertEquals(94, underTest.getHealth());
	}
	
	
	
	@Test
	public void shouldHave100OilAfterFilling() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		//System.out.println(underTest.getOil());
		underTest.fillOil();
		//System.out.println(underTest.getOil());		
		assertEquals(100, underTest.getOil());
	}
	
	@Test
	public void shouldHave100HealthAfterPerformingMaintenance() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		System.out.println(underTest.getHealth());		
		underTest.performMaitenance();
		System.out.println(underTest.getHealth());		
		assertEquals(100, underTest.getHealth());
	}
	
	
	
}
