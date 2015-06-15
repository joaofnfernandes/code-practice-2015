package chapter3.setOfStacks;

import java.util.EmptyStackException;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSetOfStacks {
	
	@Test(expected = EmptyStackException.class)
	public void TestPopEmptyQueue() {
		SetOfStacks<Integer> q = new SetOfStacks<Integer>();
		q.pop();
	}
	
	@Test
	public void TestAddRetrieveSingleStack() {
		int[] inputs = new int[] {0,1,2,3};
		SetOfStacks<Integer> q = new SetOfStacks<Integer>();
		for(int i = 0; i < inputs.length; i++) {
			q.push(inputs[i]);
		}
		for(int i = inputs.length - 1; i >= 0; i--) {
			assertEquals(inputs[i], (int)q.pop());
		}
	}
	
	@Test
	public void TestAddRetrieveMultipleStacks() {
		int size = 100;
		int[] inputs = new int[size];
		SetOfStacks<Integer> q = new SetOfStacks<Integer>();
		
		for(int i = 0; i < size; i++) {
			inputs[i] = i;
			q.push(inputs[i]);
		}
		for(int i = size - 1; i >= 0; i--) {
			assertEquals(inputs[i], (int)q.pop());
		}
		
		assertTrue(q.isEmpty());
	}
	
	

}
