package chapter3.stacks;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStack {

	@Test
	public void TestPushRetrieve() {
		int size = 100;
		int[] values = new int[size];
		Stack<Integer> ints = new Stack<Integer>();
		
		assertTrue(ints.empty());
		
		for(int i = 0; i < size; i ++) {
			values[i] = i;
			ints.push(i);	
		}
		for(int i = values.length - 1; i > 0; i--) {
			assertEquals(values[i], (int)ints.pop());
		}
	}
}
