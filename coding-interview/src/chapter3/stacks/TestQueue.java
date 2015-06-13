package chapter3.stacks;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestQueue {

	@Test
	public void TestPushRetrieve() {
		int size = 10;
		int[] values = new int[size];
		Queue<Integer> ints = new Queue<Integer>();
		
		assertTrue(ints.empty());
		
		for(int i = 0; i < size; i++) {
			values[i] = i;
			ints.push(i);	
		}
		for(int i = 0; i < values.length; i++) {
			assertEquals(values[i], (int)ints.pop());
		}
		
		// one more time to wrap around
		for(int i = 0; i < size; i ++) {
			values[i] = i;
			ints.push(i);	
		}
		for(int i = 0; i < values.length; i++) {
			assertEquals(values[i], (int)ints.pop());
		}
	}
}
