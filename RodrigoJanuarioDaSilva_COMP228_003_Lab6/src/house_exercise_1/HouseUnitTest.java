package house_exercise_1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class HouseUnitTest {

	@org.junit.Test
	public void testHouses() {
		assertEquals(6, HouseDriver.practiceCollectionsAndComparitor().size());
	}

	@Test//(expected = ClassCastException.class )
	public void testException() {
		assertThrows(ClassCastException.class,  () ->  HouseDriver.displayHouseWithoutComparitor());
	}
}
