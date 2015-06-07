package chapter1.reverseString;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestReverseString {

	@Test
	public void testReverseIterative() {
		char[] input = "abcde\0".toCharArray();
		char[] expected = "edcba\0".toCharArray();
		ReverseString.reverseIterative(input, input.length);
		
		assertEquals(new String(expected), new String(input));		
	}
	
	@Test
	public void testReverseRecursive(){
		char[] input = "abcde\0".toCharArray();
		char[] expected = "edcba\0".toCharArray();
		ReverseString.reverseRecursive(input, input.length);
		
		assertEquals(new String(expected), new String(input));		
	}
	
}
