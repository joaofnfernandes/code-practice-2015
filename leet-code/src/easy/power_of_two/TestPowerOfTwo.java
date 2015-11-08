package easy.power_of_two;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPowerOfTwo {

    @Test
    public void testIsPowerOfTwo() {
        int[] inputs = {1,2,4,8,16,32,64,2048, 33554432};
        Solution sol = new Solution();
        for (int n : inputs) {
            assertTrue(String.format("%d is power of two", n),sol.isPowerOfTwo(n));
        }
    }
    
    @Test
    public void testNotPowerOfTwo(){
        int[] inputs = {0,3,7,15,60,61,62,63,65,33554431,33554433, -3, -7, -15, -16, -2147483646};
        Solution sol = new Solution();
        for (int n : inputs) {
            assertFalse(String.format("%d is not power of two", n),sol.isPowerOfTwo(n));
        }
    }
}
