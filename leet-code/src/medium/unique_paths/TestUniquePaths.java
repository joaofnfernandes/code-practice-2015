package medium.unique_paths;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestUniquePaths {

    @Test
    public void test2X2() {
        int m = 2;
        int n = 2;
        int expected = 2;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
    
    @Test
    public void test3X2() {
        int m = 3;
        int n = 2;
        int expected = 3;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
    
    @Test
    public void test3X3() {
        int m = 3;
        int n = 3;
        int expected = 6;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
    
    @Test
    public void test4X2() {
        int m = 4;
        int n = 2;
        int expected = 4;
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
}
