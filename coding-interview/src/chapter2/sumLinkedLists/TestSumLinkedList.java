package chapter2.sumLinkedLists;

import org.junit.Test;

import chapter2.sumLinkedLists.LinkedList.InvalidValueException;
import static org.junit.Assert.*;

public class TestSumLinkedList {

	@Test
	public void TestSumZeros() throws InvalidValueException {
		Integer[] expected = new Integer[] {1,2,3,4};
		
		LinkedList l1 = new LinkedList(expected);
		LinkedList l2 = new LinkedList(new Integer[] {0});
		LinkedList sum = LinkedList.sum(l1, l2);
	
		assertArrayEquals(expected, sum.toArray());
		
	}
	
	@Test
	public void TestSumNoCarry() throws InvalidValueException {
		
		
		LinkedList l1 = new LinkedList(new Integer[] {0,1,2,3,4});
		LinkedList l2 = new LinkedList(new Integer[] {4,3,2,1,0});
		LinkedList sum = LinkedList.sum(l1, l2);
	
		assertArrayEquals(new Integer[] {4,4,4,4,4}, sum.toArray());
	}
	
	@Test
	public void TestSumWithCarry() throws InvalidValueException  {
		LinkedList l1 = new LinkedList(new Integer[] {1,9,9});
		LinkedList l2 = new LinkedList(new Integer[] {1,9,9});
		LinkedList sum = LinkedList.sum(l1, l2);
	
		assertArrayEquals(new Integer[] {3,9,8}, sum.toArray());
	}
	
	@Test
	public void TestSumWithCarryOnMostSignificantDigit() throws InvalidValueException  {
		LinkedList l1 = new LinkedList(new Integer[] {9,9,9});
		LinkedList l2 = new LinkedList(new Integer[] {9,9,9});
		LinkedList sum = LinkedList.sum(l1, l2);
	
		assertArrayEquals(new Integer[] {1,9,9,8}, sum.toArray());
	}

}
