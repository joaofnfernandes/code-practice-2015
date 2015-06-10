package chapter2.linkedList;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestLinkedList {
	
	@Test
	public void TestAddFirst() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		Integer firstValue = 1;
		
		ints.addFirst(firstValue);
		assertThat(ints.getFirst(), is(firstValue));
		assertThat(ints.getLast(), is(firstValue));
		
		Integer secondValue = 2;
		ints.addFirst(secondValue);
		assertThat(ints.getFirst(), is(secondValue));
		assertThat(ints.getLast(), is(firstValue));
	}
	
	@Test
	public void TestAddLast() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		Integer firstValue = 1;
		
		ints.addLast(firstValue);
		assertThat(ints.getFirst(), is(firstValue));
		assertThat(ints.getLast(), is(firstValue));
		
		Integer secondValue = 2;
		ints.addLast(secondValue);
		assertThat(ints.getFirst(), is(firstValue));
		assertThat(ints.getLast(), is(secondValue));
	}
	
	@Test
	public void TestAdd() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		Integer firstValue  = 1;
		Integer middleValue = 2;
		Integer lastValue = 3;
		
		ints.add(middleValue, 0);
		ints.add(firstValue, 0);
		ints.add(lastValue, 2);
		
		assertThat(ints.removeFirst(), is(firstValue));
		assertThat(ints.removeFirst(), is(middleValue));
		assertThat(ints.removeFirst(), is(lastValue));
		
	}
	
	@Test
	public void TestGet() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		ints.addFirst(1);
		ints.addLast(2);
		
		assertThat(ints.get(-1), is(1));
		assertThat(ints.get(0), is(1));
		
		assertThat(ints.get(1), is(2));
		assertThat(ints.get(10), is(2));
		
	}
	
	@Test
	public void TestContains() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		Integer value = 1;
		ints.addFirst(value);
		
		assertTrue(ints.contains(value));
		ints.removeFirst();
		assertFalse(ints.contains(value));
	}
	
	@Test
	public void TestRemoveFirst() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		Integer firstValue = 1;
		Integer secondValue = 2;
		
		
		ints.addFirst(secondValue);
		ints.addFirst(firstValue);
		
		assertThat(ints.removeFirst(), is(firstValue));
		assertThat(ints.removeFirst(), is(secondValue));
		
	}
	
	@Test
	public void TestRemove() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		
		Integer firstValue  = 1;
		Integer middleValue = 2;
		Integer lastValue = 3;
		
		ints.add(middleValue, 0);
		ints.add(firstValue, 0);
		ints.add(lastValue, 2);
		
		assertThat(ints.remove(1), is(middleValue));
		assertThat(ints.remove(100), is(lastValue));
		assertThat(ints.remove(-1), is(firstValue));
	}
	
	@Test
	public void TestRemoveDuplicates() {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		
		ints.addFirst(1);
		ints.removeDuplicates();
		assertThat(ints.size(), is(1));
		
		ints.addFirst(1);
		ints.addFirst(2);
		ints.addFirst(1); // 1,2,1,1
		ints.removeDuplicates();
		assertThat(ints.size(), is(2));
		assertThat(ints.getFirst(), is(1));
		assertThat(ints.getLast(), is(2));
		
	}

}
