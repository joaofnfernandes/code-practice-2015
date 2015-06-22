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

}
