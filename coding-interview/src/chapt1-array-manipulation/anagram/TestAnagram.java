package anagram;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAnagram {
	
	@Test
	public void TestIsAnagram() {
		String a1 = "iceman";
		String a2 = "cinema";
		String b1 = "cineman";
		
		assertTrue(Anagram.isAnagram(a1, a2));
		assertFalse(Anagram.isAnagram(a1, b1));
	}

}
