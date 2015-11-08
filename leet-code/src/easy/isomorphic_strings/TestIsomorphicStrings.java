package easy.isomorphic_strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIsomorphicStrings {

    @Test
    public void testNotIsomorphic() {
        String[] s = { "aa", "aaba"};
        String[] t = { "ab", "aaaa"};
        Solution sol = new Solution();
        for (int i = 0; i < s.length; i++) {
            assertFalse(sol.isIsomorphic(s[i], t[i]));
        }
    }

    @Test
    public void testIsIsomorphic() {
        String[] s = { "", "cat", "cat", "egg", "paper" };
        String[] t = { "", "cat", "cow", "add", "title" };
        Solution sol = new Solution();
        for (int i = 0; i < s.length; i++) {
            assertTrue(sol.isIsomorphic(s[i], t[i]));
        }
    }

}
