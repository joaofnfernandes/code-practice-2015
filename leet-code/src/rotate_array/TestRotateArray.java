package rotate_array;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRotateArray {

    @Test
    public void testRotateArray() {
        int n = 6;
        int[] input, expected;
        Solution sol = new Solution();
        for (int i = 0; i < n; i++) {
            input = makeArray(n);
            expected = makeArray(n, i);
            sol.rotate(input, i);
            assertArrayEquals(String.format("Failed on iteration %d", i),expected, input);
        }
    }
    
    @Test
    public void testKGreaterThanLength() {
        int n = 1;
        int k = 2;
        int[] input = makeArray(n); 
        int[] expected = makeArray(n);
        new Solution().rotate(input, k);
        assertArrayEquals(expected, input);
    }
    
    private int[] makeArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
    
    private int[] makeArray(int length, int startValue) {
        int[] arr = new int[length];
        for (int i = startValue; i < length ; i++) {
            arr[i] = i - startValue;
        }
        for (int i = 0; i < startValue; i++) {
            arr[i] = length - startValue + i;
        }
        return arr;
    }
}
