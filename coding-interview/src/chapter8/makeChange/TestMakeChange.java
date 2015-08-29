package chapter8.makeChange;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMakeChange {

	@Test
	public void TestNoChange() {
		String expected = "[0,0,0]";
		
		MakeChange makeChange = new MakeChange();
		String result = makeChange.GetChange(0); 
		
		assertTrue(result.contains(expected));
	}
	
	@Test
	public void TestOneCombination() {
		MakeChange makeChange = new MakeChange();
		String result;
		
		String expected = "[0,0,1]";
		result = makeChange.GetChange(1);

		assertTrue(result.contains(expected));
		
		expected = "[0,0,9]";
		result = makeChange.GetChange(9);
		
		assertTrue(result.contains(expected));
	}
	
	@Test
	public void TestMultipleCombinations() {
		test10Cents();
		test25Cents();
	}
	
	public void test10Cents() {
		MakeChange makeChange = new MakeChange();
		String[] expected = new String[]{"[0,1,0]", "[0,0,10]"};
		String result = makeChange.GetChange(10);
		System.out.println(result);
		for(String s : expected) {
			assertTrue(result.contains(s));
		}
	}
	
	public void test25Cents() {
		MakeChange makeChange = new MakeChange();
		String[] expected = new String[]{"[1,0,0]","[0,2,5]", "[0,0,25]"};
		String result = makeChange.GetChange(25);
		
		for(String s : expected) {
			assertTrue(result.contains(s));
		}
	}
	
}
