package word_pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWordPattern {

    @Test
    public void testDontMatchEmptyPattern(){
        String pattern = "";
        String text = "dog cat";
        Solution sol = new Solution();
        assertFalse(sol.wordPattern(pattern, text));
    }
    
    @Test
    public void testsDontMatchSamePattern1(){
        String pattern = "aa";
        String text = "dog cat";
        Solution sol = new Solution();
        assertFalse(sol.wordPattern(pattern, text));
    }
    
    @Test
    public void testsDontMatchMixedPattern1(){
        String pattern = "aba";
        String text = "dog dog dog";
        Solution sol = new Solution();
        assertFalse(sol.wordPattern(pattern, text));
    }
    
    @Test
    public void testDontMatchMixedPattern2(){
        String pattern = "aba";
        String text = "dog cat cat";
        Solution sol = new Solution();
        assertFalse(sol.wordPattern(pattern, text));
    }
    
    @Test
    public void testMatchSamePattern(){
        String pattern = "aa";
        String text = "dog dog";
        Solution sol = new Solution();
        assertTrue(sol.wordPattern(pattern, text));
    }
    
    @Test
    public void testMatchMixedPattern1(){
        String pattern = "aba";
        String text = "dog cat dog";
        Solution sol = new Solution();
        assertTrue(sol.wordPattern(pattern, text));
    }
    @Test
    public void testMatchMixedPattern2(){
        String pattern = "aabbac";
        String text = "dog dog cat cat dog cow";
        Solution sol = new Solution();
        assertTrue(sol.wordPattern(pattern, text));
    }
}
