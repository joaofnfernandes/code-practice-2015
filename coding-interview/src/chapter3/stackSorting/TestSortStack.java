package chapter3.stackSorting;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortStack {
	
	@Test
	public void testSortSorted() {
		Integer[] values = new Integer[] {0,1,2,3,4,5};
		
		Stack<Integer> s = new Stack<>();
		s.addAll(Arrays.asList(values));
		
		s = new SortStack<Integer>().sort(s);
		
		for(int i = 0; i < values.length; i++) {
			assertEquals(values[i], s.pop());
		}
	}
	
	@Test
	public void testSortReversed() {
		Integer[] values = new Integer[] {5,4,3,2,1,0};
		
		Stack<Integer> s = new Stack<>();
		s.addAll(Arrays.asList(values));
		
		s = new SortStack<Integer>().sort(s);
		
		for(int i = values.length - 1; i <= 0; i--) {
			assertEquals(values[i], s.pop());
		}
	}
	
	@Test
	public void testSortMixed() {
		Integer[] input = new Integer[] {4,5,2,3,1,0};
		Integer[] expected = new Integer[] {0,1,2,3,4,5};
		
		Stack<Integer> s = new Stack<>();
		s.addAll(Arrays.asList(input));
		
		s = new SortStack<Integer>().sort(s);
		
		for(int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], s.pop());
		}
	}

}
