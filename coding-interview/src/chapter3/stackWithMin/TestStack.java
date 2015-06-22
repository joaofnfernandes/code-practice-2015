package chapter3.stackWithMin;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStack {
	
	@Test
	public void TestStackWithDescendingValues() {
		int[] values = new int[] {5,4,3,2,1,0};
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			stack.push(values[i]);
		}
		
		for(int i = values.length - 1; i <= 0; i--) {
			assertEquals(values[i], (int)stack.min());
			assertEquals(values[i], (int)stack.pop());
		}
	}
	
	@Test
	public void TestStackWithAscendingValues() {
		int[] values = new int[] {0,1,2,3,4,5};
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			stack.push(values[i]);
		}
		
		for(int i = 0; i < values.length; i++) {
			assertEquals(values[0], (int)stack.min());
			assertEquals(values[values.length - 1 - i], (int)stack.pop());
		}
	}

}
