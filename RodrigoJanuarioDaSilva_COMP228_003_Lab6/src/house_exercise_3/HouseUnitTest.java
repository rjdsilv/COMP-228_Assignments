package house_exercise_3;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class HouseUnitTest {

	@Test//(expected = ClassCastException.class )
	public void testWithException() {
		MessageHolder m = new MessageHolder();
		HouseDriver.practiceCollectionsAndComparitor(7, m);
		assertEquals(MessageHolder.FINALLY_MESSAGE, m.getMessage());
	}

	@Test//(expected = ClassCastException.class )
	public void testWithoutException() {
		MessageHolder m = new MessageHolder();
		HouseDriver.practiceCollectionsAndComparitor(2, m);
		assertEquals(MessageHolder.FINALLY_MESSAGE, m.getMessage());
	}
}
