package chapter3.QueueTwoStacks;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestQueue {
	
	@Test
	public void TestPushPop() {
		int[] values = new int[] {0,1,2,3,4,5};
		Queue<Integer> q = new Queue<Integer>();
		for(int i = 0; i < values.length; i++) {
			q.push(values[i]);
		}
		
		for(int i = 0; i < values.length; i++) {
			assertEquals(values[i], (int)q.pop());
		}
	}
	
	@Test 
	public void TestPushPopMixed() {
		int[] values = new int[] {0,1,2,3,4,5,6,7};
		Queue<Integer> q = new Queue<Integer>();
		final int firstIteration = 2;
		for(int i = 0; i < values.length / 2; i++) {
			q.push(values[i]);
		}
		
		for(int i = 0; i < firstIteration; i++) {
			assertEquals(values[i], (int)q.pop());
		}
		
		for(int i = values.length / 2; i < values.length; i++) {
			q.push(values[i]);
		}
		
		for(int i = firstIteration; i < values.length; i++) {
			assertEquals(values[i], (int)q.pop());
		}
	}

}
