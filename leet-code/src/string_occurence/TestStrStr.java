package string_occurence;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStrStr {
    
    @Test
    public void testNoOccurrences() {
        String[] inputs = {"", "a", "ab", "aba", "cba", "aaabbbccc"};
        String pattern = "abc";
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(-1, sol.strStr(inputs[i], pattern));
        }
    }
    
    @Test
    public void testExistingOccurences() {
        String[] inputs = {"abc", "abcddd", "abcabcabc", "abababcddd", "abababcabc", "abababc"};
        int[] expectedResults = {0, 0, 0, 4, 4, 4};
        String pattern = "abc";
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expectedResults[i], sol.strStr(inputs[i], pattern));
        }
    }
    
    @Test
    public void testNoPattern(){
        String[] inputs = {"", "a", "ab", "aba", "cba", "aaabbbccc"};
        String pattern = "";
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(0, sol.strStr(inputs[i], pattern));
        }
    }

}
