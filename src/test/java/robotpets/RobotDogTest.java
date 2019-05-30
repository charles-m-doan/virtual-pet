package robotpets;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RobotDogTest {

	RobotPet underTest = new RobotDog("Boy");

	public RobotDogTest() {
	}

	@Test
	public void shouldHave98OilAfter2Ticks() {
		underTest.tick();
		underTest.tick();
		assertEquals(98, underTest.getOil());
	}

	@Test
	public void shouldHave80OilAfter2Plays() {
		underTest.play();
		underTest.play();
		assertEquals(80, underTest.getOil());
	}

	@Test
	public void shouldHave86OilAfter2Walks() {
		underTest.walk();
		underTest.walk();
		assertEquals(86, underTest.getOil());
	}
	
	@Test
	public void shouldHave98HealthAfter2Ticks() {
		underTest.tick();
		underTest.tick();
		assertEquals(98, underTest.getHealth());
	}
	
	@Test
	public void shouldHave78HealthAfter2Plays() {
		underTest.play();
		underTest.play();
		assertEquals(78, underTest.getHealth());
	}
	
	@Test
	public void shouldHave88HealthAfter2Walks() {
		underTest.walk();
		underTest.walk();
		assertEquals(88, underTest.getHealth());
	}

	@Test
	public void shouldHave100OilAfterFilling() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		System.out.println(underTest.getOil());
		underTest.fillOil();
		System.out.println(underTest.getOil());
		assertEquals(100, underTest.getOil());
	}

	@Test
	public void shouldHave100HealthAfterPerformingMaintenance() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		System.out.println(underTest.getHealth());
		underTest.restoreHealth();
		System.out.println(underTest.getHealth());
		assertEquals(100, underTest.getHealth());
	}

}
