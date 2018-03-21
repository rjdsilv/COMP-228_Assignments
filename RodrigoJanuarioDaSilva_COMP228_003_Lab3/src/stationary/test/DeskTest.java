package stationary.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import stationary.Crayon;
import stationary.Desk;
import stationary.Eraser;
import stationary.Pen;
import stationary.Pencil;
import stationary.Crayon.Color;
import stationary.Pen.Type;
import stationary.Pencil.Hardness;

/**
 * Test class responsible for testing the Desk class methods.
 * 
 * @author Rodrigo Januario da Silva
 */
class DeskTest {
	/**
	 * Tests the add item method not passing the maximum capacity.
	 */
	@Test
	void testAddItem() {
		final Desk desk = new Desk();
		assertEquals(0, desk.getItemList().size());

		assertTrue(desk.addItem(new Eraser("ERS-80Y")));
		assertEquals(1, desk.getItemList().size());
		
		assertTrue(desk.addItem(new Pencil("PCL-2B", Hardness._2B)));
		assertEquals(2, desk.getItemList().size());
		
		assertTrue(desk.addItem(new Crayon("CRY-R09B", Color.RED)));
		assertEquals(3, desk.getItemList().size());
		
		assertTrue(desk.addItem(new Pen("PEN-B80X", Type.QUILL)));
		assertEquals(4, desk.getItemList().size());
	}

	/**
	 * Tests the add item method not exceeding the maximum capacity.
	 */
	@Test
	void testAddItemExceedCapacity() {
		final Desk desk = new Desk();
		assertTrue(desk.addItem(new Eraser("ERS-80Y")));
		assertTrue(desk.addItem(new Pencil("PCL-2B", Hardness._2B)));
		assertTrue(desk.addItem(new Crayon("CRY-R09B", Color.RED)));
		assertTrue(desk.addItem(new Pen("PEN-B80X", Type.QUILL)));
		assertFalse(desk.addItem(new Eraser("ERS-93X")));
	}

	/**
	 * Tests the getItemList without trying to modify the returned list.
	 */
	@Test
	void testGetItemList() {
		final Desk desk = new Desk();
		assertTrue(desk.addItem(new Eraser("ERS-80Y")));
		assertTrue(desk.addItem(new Pencil("PCL-2B", Hardness._2B)));
		assertTrue(desk.addItem(new Crayon("CRY-R09B", Color.RED)));
		assertTrue(desk.addItem(new Pen("PEN-B80X", Type.QUILL)));
		assertEquals(4, desk.getItemList().size());
	}

	/**
	 * Tests the getItemList trying to modify the returned list.
	 */
	@Test
	void testGetItemListModifyingList() {
		final Desk desk = new Desk();
		final Executable codeContainingCodeToTest = () -> desk.getItemList().add(new Pen("PEN-B80X", Type.QUILL));
		assertThrows(UnsupportedOperationException.class, codeContainingCodeToTest);
	}
}
