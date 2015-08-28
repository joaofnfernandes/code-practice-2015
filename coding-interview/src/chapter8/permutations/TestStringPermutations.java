package chapter8.permutations;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStringPermutations {
	
	@Test
	public void TestEmptyString() {
		String expected = "[]";
		StringPermutations permutations = new StringPermutations("");
		String result = permutations.GetPermutations();
		
		assertTrue(result.contains(expected));
	}
	
	@Test
	public void TestChar() {
		String expected = "a";
		StringPermutations permutations = new StringPermutations("a");
		String result = permutations.GetPermutations();
		
		assertTrue(result.contains(expected));
	}
	
	@Test
	public void TestString() {
		String[] expectedResults = new String[] {"abc", "acb",
												"bac", "bca",
												"cab", "cba"};
		StringPermutations permutations = new StringPermutations("abc");
		String result = permutations.GetPermutations();
		
		for(String expected : expectedResults) {
			assertTrue(result.contains(expected));
		}
	}

}
