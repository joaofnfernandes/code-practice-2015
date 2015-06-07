package palindrome;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
	@Test
	public void TestPalindromeIter() {
		String pal1 = "anona";
		String pal2 = "nursesrun";
		String notpal = "anon";
		
		assertTrue(Palindrome.isPalindromeIterative(pal1));
		assertTrue(Palindrome.isPalindromeIterative(pal2));
		assertFalse(Palindrome.isPalindromeIterative(notpal));
	}
	
	@Test
	public void TestPalindromeRecur() {
		String pal1 = "anona";
		String pal2 = "nursesrun";
		String notpal = "anon";
		
		assertTrue(Palindrome.isPalindromeRecursive(pal1));
		assertTrue(Palindrome.isPalindromeRecursive(pal2));
		assertFalse(Palindrome.isPalindromeRecursive(notpal));
	}

}
