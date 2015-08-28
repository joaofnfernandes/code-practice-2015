package chapter8.parensCombination;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestParens {
	
	@Test
	public void Test0Parens() {
		String expected = "";
		Parens p = new Parens(0);
		String result = p.GetCombinations();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void Test1Parens() {
		String expected = "()";
		Parens p = new Parens(1);
		String result = p.GetCombinations();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void Test2Parens() {
		String expected = "(())";
		Parens p = new Parens(2);
		String result = p.GetCombinations();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void Test4Parens() {
		String[] expectedResults = new String[] {"(()()())", "((()()))", "(()(()))", "((())())", "(((())))"};
		Parens p = new Parens(4);
		String result = p.GetCombinations();
		System.out.println(result);
		for(String expected : expectedResults) {
			assertTrue(result.contains(expected));
		}
	}

}
