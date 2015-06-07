package arrayLists;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayList {

	@Test
	public void testEmptyList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		assertEquals("List should be empty", 0, list.count());
		assertTrue("List should be empty", list.isEmpty());
	}
	
	@Test
	public void testAddRetrieve() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		assertFalse("List shouldn't be empty", list.isEmpty());
		assertTrue("List should contain element 1", list.contains(1));
		assertEquals("List should contain element at [0]", 1 , (int)list.get(0));
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void testSetEmptyList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.set(1, 0);
	}
	
	@Test
	public void testAddSet() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.set(2, 0);
		assertEquals("List should contain 2", 2, (int)list.get(0));
	}
	
	@Test
	public void testAddRemove() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.remove(0);
		
		assertFalse("List shouldn't be empty", list.isEmpty());
		assertFalse("1 should not exist on the list", list.contains(1));
		assertTrue("2 should exist on the list", list.contains(2));
	}
	
	
	
	
	
}
