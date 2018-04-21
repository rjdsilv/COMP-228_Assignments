package house_exercise_2;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class HouseUnitTest {
	@Test//(expected = IndexOutOfBoundsException.class )
	public void testException1() {
		assertThrows(IndexOutOfBoundsException.class, () -> HouseDriver.practiceCollectionsAndComparitor(7, new House(350.00, "350")));
	}

	
	@Test//(expected = ClassCastException.class )
	public void testHouses() {
		assertThrows(ClassCastException.class, () -> HouseDriver.practiceCollectionsAndComparitor(2, new HouseComparable(350.00, "350")));
	}
}
