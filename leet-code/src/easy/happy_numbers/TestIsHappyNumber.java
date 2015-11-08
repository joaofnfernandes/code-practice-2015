package easy.happy_numbers;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestIsHappyNumber {

    @Test
    public void testHappyNumbers() {
        int[] input = { 1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79,
                82 };
        Solution sol = new Solution();
        boolean result;
        for (int n : input) {
            result = sol.isHappy(n);
            assertTrue(String.format("happy(%d) should be true", n), result);
        }
    }

    @Test
    public void testNotHappyNumbers() {
        int[] input = { 2, 3, 4, 5, 6, 8, 9 };
        Solution sol = new Solution();
        for (int n : input) {
            assertFalse(sol.isHappy(n));
        }
    }
}
