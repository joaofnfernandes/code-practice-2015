package medium.missing_number;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMissingNumber {

    @Test
    public void testMissingNumber() {
        int[][] inputs = {{0},{1},{0,1,3}, {3,1,0}, {1,2,3}, {0,1,2}};
        int[] expected = {1, 0, 2, 2, 0, 3};
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expected[i], sol.missingNumber(inputs[i]));
        }
    }
}
