package longest_common_prefix;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestLongestCommonStr {

    @Test
    public void testNoWords(){
        String[] words = {};
        String expected = "";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
    
    @Test
    public void testSameWord(){
        String[] words = {"cat", "cat", "cat", "cat"};
        String expected = "cat";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
    
    @Test
    public void testDifferentWords1(){
        String[] words = {"cat", "hat"};
        String expected = "";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
    
    @Test
    public void testDifferentWords2(){
        String[] words = {"cat", "cow", "dog", "duck"};
        String expected = "";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
    
    @Test
    public void testSmallestWordIsFirstWord(){
        String[] words = {"cat", "catdog", "catfrog", "catsheet"};
        String expected = "cat";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
    
    @Test
    public void testSmallestWordIsMiddleWord(){
        String[] words = {"catdog", "cat", "catfrog", "catdog"};
        String expected = "cat";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
    
    @Test
    public void testSmallestSubstrIsSubstrFirstWord(){
        String[] words = {"catdog", "catfrog", "catfrog", "catcow"};
        String expected = "cat";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
    
    @Test
    public void testSmallestSubstrIsSubstrMiddleWord(){
        String[] words = {"catdog", "catdog", "catfrog", "catfrog"};
        String expected = "cat";
        Solution sol = new Solution();
        assertEquals(expected, sol.longestCommonPrefix(words));
    }
}
