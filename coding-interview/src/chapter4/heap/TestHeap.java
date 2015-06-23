package chapter4.heap;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHeap {
	
	@Test
	public void TestCreateContains() {
		Integer[] values = new Integer[] {0,1,2,3,4,5};
		Heap<Integer> heap = new Heap<>(values);
		
		for(int i = 0; i < values.length; i++) {
			assertTrue(heap.contains(values[i]));
		}
	}
	
	@Test
	public void TestMax() {
		Integer[] initialValue = new Integer[] {0,1,2};
		Heap<Integer> heap = new Heap<>(initialValue);
		
		assertEquals(initialValue[2], heap.max());
				
		for(int i = 3; i < 10; i++) {
			heap.insert(i);
			assertEquals(new Integer(i), heap.max());
		}
	}
	
	@Test
	public void TestPop() {
		Integer[] values = new Integer[] {0,1,2,3,4,5};
		Heap<Integer> heap = new Heap<>(values);
		
		for(int i = values.length - 1; i <= 0; i++) {
			assertEquals(values[i], heap.pop());
		}
	}

}
