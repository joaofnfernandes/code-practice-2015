package palindrome_string;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalindromeString {

    @Test
    public void testIsPalindrome(){
        String[] input = {"", "a", "  Aa", "1aBccba 1", "a b C,c!b a", "A man, a plan, a canal: Panama"};
        Solution sol = new Solution();
        for (String s : input) {
            assertTrue(String.format("%s is a palindrome", s) ,sol.isPalindrome(s));
            assertTrue(sol.isPalindrome2(s));
        }
    }
    
    @Test
    public void testNotPalindrome(){
        String[] input = {"ab", "a1b", "1a", "race a car"};
        Solution sol = new Solution();
        for (String s : input) {
            assertFalse(String.format("%s is not a palindrome", s),sol.isPalindrome(s));
            assertFalse(String.format("%s is not a palindrome", s),sol.isPalindrome2(s));
        }
    }
}
