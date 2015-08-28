package chapter8.subsets;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSubsets {

	@Test
	public void TestNoSubsets() {
		String expected = "[]";
		Subsets s = new Subsets(Arrays.asList(new Integer[] {}));
		
		assertEquals(expected, s.GetSubsets());
	}
	
	@Test
	public void TestOneSubset() {
		String expected = "[1]";
		Subsets s = new Subsets(Arrays.asList(new Integer[] {1}));
		String result = s.GetSubsets();
		
		assertTrue(result.contains(expected));
	}
	
	@Test
	public void TestNSubsets() {
		String[] expectedResults = new String[] {"[1]", "[2]", "[3]", "[1, 2]", "[1, 3]", "[2, 3]", "[1, 2, 3]"};
		Subsets s = new Subsets(Arrays.asList(new Integer[] {1,2,3}));
		String result = s.GetSubsets();
		
		for(String expected : expectedResults) {
			assertTrue(result.contains(expected));
		}
	}
}
