package easy.palindrome_number;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIsNumberPalindrome {

    @Test
    public void testNumberIsPalindrome(){
        int[] inputs = {0,1,9,11,99,101,111, 1001, 1221, 12321};
        Solution sol = new Solution();
        for (int n : inputs) {
            assertTrue(String.format("%d is a palindrome", n),sol.isPalindrome(n));
        }
    }
    
    @Test
    public void testNumberIsNotPalindrome(){
        int[] inputs = {10, 12, 98, 100, 511111, 11115, 111511, 1000021, Integer.MAX_VALUE};
        Solution sol = new Solution();
        for (int n : inputs) {
            assertFalse(String.format("%d is not a palindrome", n),sol.isPalindrome(n));
        }
    }
}
