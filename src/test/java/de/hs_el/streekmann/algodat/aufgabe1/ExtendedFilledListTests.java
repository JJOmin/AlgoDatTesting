package de.hs_el.streekmann.algodat.aufgabe1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ExtendedFilledListTests {

	private List<Integer> list;

	@BeforeEach
	void setUp() {
		list = new LinkedList<>();
		for (int i=0; i<9; i++) {
			list.add(i);
		}
	}
	
	@Test
	void testIndexOfElementExists() {
		int index = list.indexOf(3);
		assertEquals(3, index);
	}
	
	@Test
	void testIndexOfNonExistingElement() {
		int index = list.indexOf(9);
		assertEquals(-1, index);
	}
	
	@Test
	@Disabled
	void testIndexOfNull() { // warum wird dieser Test Ignoriert???
		list.add(null);
		list.add(10);
		assertEquals(9, (int)list.indexOf(null));
	}
	
	@Test
	void testRemoveFirstIndex() {
		int removedElement = list.remove(0);
		assertEquals(0, removedElement);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(1), list.get(0));
	}
	
	@Test
	void testRemoveLastIndex() {
		int removedElement = list.remove(8);
		assertEquals(8, removedElement);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(7), list.get(7));
		list.add(10);
		assertEquals(10, list.get(8));

	}
	
	@Test
	void testRemoveMiddleIndex() {
		int removedElement = list.remove(4);
		assertEquals(4, removedElement);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(8), list.get(7));
	}
	
	@Test
	void testRemoveFirstElement() {
		boolean removed = list.remove(Integer.valueOf(0));
		assertTrue(removed);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(1), list.get(0));
	}
	
	@Test
	void testRemoveLastElement() {
		boolean removed = list.remove(Integer.valueOf(8));
		assertTrue(removed);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(7), list.get(7));
		list.add(10);
		assertEquals(10, list.get(8));

	}
	
	@Test
	void testRemoveMiddleElement() {
		boolean removed = list.remove(Integer.valueOf(4));
		assertTrue(removed);
		assertEquals(8, list.size());
		assertEquals(Integer.valueOf(8), list.get(7));
	}
	
	@Test
	void testRemovePreIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
	}
	
	@Test
	void testRemovePostIndex() {
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(9));
	}
	
	@Test 
	void testRemoveUncontainedElement() {
		boolean removed = list.remove(Integer.valueOf(9));
		assertFalse(removed);
		assertEquals(9, list.size());
	}

	@Test
	void testRemoveAFewElementsAndAddSome() {
		int[] expectedArray = { 1,2,3,5,6,7,9,10 };
		int[] actualArray = new int[8];

		list.remove(Integer.valueOf(8));
		list.remove(0);
		list.remove(3);
		list.add(9);
		list.add(10);

		// Liste auslesen und in actualArray schreiben
		int j = 0;
		for (int i : list) {
			actualArray[j++]=i;
		}
		assertArrayEquals(expectedArray, actualArray);

	}

}
