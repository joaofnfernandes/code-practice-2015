package palindrome_list;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;



public class TestPalindromeList {

    @Test
    public void testIsPalindrome() {
        Integer[][] inputs = {{}, {1}, {1,1}, {1,2,1}, {1,2,3,3,2,1}};
        Solution sol = new Solution();
        for (Integer[] input : inputs) {
            assertTrue(String.format("%s is a palindrome", Arrays.toString(input)),
                        sol.isPalindrome(makeList(input)));
        }
    }
    
    //@Test
    public void testNotPalindrome() {
        Integer[][] inputs = {{1,2}, {1,2,3,3,2}, {1,2,3,3,2,2}};
        Solution sol = new Solution();
        for (Integer[] input : inputs) {
            assertFalse(String.format("%s isn't a palindrome", Arrays.toString(input)),
                        sol.isPalindrome(makeList(input)));
        }
    }
    
    private ListNode makeList(Integer[] values) {
        return makeList(values, 0);
    }
    
    private ListNode makeList(Integer[] values, int i) {
        if(i >= values.length) {
            return null;
        } else {
            ListNode node = new ListNode(values[i]);
            node.next = makeList(values, i + 1);
            return node;
        }
    }
}
