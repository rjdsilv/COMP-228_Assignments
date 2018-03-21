package stationary.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stationary.Pencil;
import stationary.Pencil.Hardness;

/**
 * Test class responsible for testing the Pencil class methods.
 * 
 * @author Rodrigo Januario da Silva
 */
class PencilTest {
	/**
	 * Tests the erase method for the pencil.
	 */
	@Test
	void testErase() {
		final Pencil pencil = new Pencil("PCL-K6HBL", Hardness._6HB);
		pencil.write("This is a sample text");
		assertEquals("This is a sample text", pencil.getText());
		pencil.erase();
		assertEquals("", pencil.getText());
	}

	/**
	 * Tests the write method for the pencil.
	 */
	@Test
	void testWrite() {
		final Pencil pencil = new Pencil("PCL-K6HBL", Hardness._6HB);
		pencil.write("This is a sample text");
		assertEquals("This is a sample text", pencil.getText());
	}
}
