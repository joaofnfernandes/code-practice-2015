package single_number;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestSingleNumber {

    @Test
    public void testSingleNumber() {
        int[][] inputs = {{0},{0,1,2,1,2}, {1,0,1,2,2}, {2,2,1,1,0}, {0,1,2,0,2}, {0,0,1,2,2}, {0,1,0,1,2}};
        int[] expected = {0, 0, 0, 0, 1, 1, 2};
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(String.format("%s", Arrays.toString(inputs[i])),
                        expected[i], sol.singleNumber(inputs[i]));
        }
    }
}
