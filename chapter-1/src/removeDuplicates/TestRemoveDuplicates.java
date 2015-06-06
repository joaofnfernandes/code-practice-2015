package removeDuplicates;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRemoveDuplicates {

	@Test
	public void TestRemoveDuplicatesIterSequence() {
		char[] input = "aaabbcddd\0".toCharArray();
		char[] expected = "abcd\0\0\0\0\0\0".toCharArray();
		RemoveDuplicates.removeIterative(input, input.length);
		
		assertEquals(new String(expected), new String(input));
	}
	
	@Test
	public void TestRemoveDuplicatesIterNotSequence() {
		char[] input = "abcabbcaa\0".toCharArray();
		char[] expected = "abc\0\0\0\0\0\0\0".toCharArray();
		RemoveDuplicates.removeIterative(input, input.length);
				
		assertEquals(new String(expected), new String(input));
	}
	
}
