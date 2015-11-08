package easy.is_anagram;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIsAnagram {

    @Test
    public void testOneChar() {
        String[] strings = {"a", "b", "c"};
        Solution sol = new Solution();
        for (String s : strings) {
            assertTrue(sol.isAnagram(s, s));
        }
    }
    
    @Test
    public void testIsAnagram() {
        String[] strings = { "anagram", "nagaram", 
                            "man", "nam"};
        Solution sol = new Solution();
        for (int i = 0; i < strings.length - 1; i=i+2) {
            assertTrue(sol.isAnagram(strings[i], strings[i + 1]));
        }
    }
    
    @Test
    public void testIsNotAnagram() {
        String[] strings = { "rat", "cat", "car", "par"};
        Solution sol = new Solution();
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if(i != j) {
                    assertFalse(sol.isAnagram(strings[i], strings[j]));
                }
            }
        }
    }
    
}
