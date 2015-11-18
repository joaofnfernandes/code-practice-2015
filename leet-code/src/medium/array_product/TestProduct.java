package medium.array_product;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestProduct {

    @Test
    public void testProductExceptSelf() {
        int[][] inputs =    {{1,2,3,4}, {0,1,2,3}, {1,2,3,0}, {1,1,1,1}};
        int[][] expected =  {{24,12,8,6}, {6,0,0,0}, {0,0,0,6}, {1,1,1,1}};
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertArrayEquals(expected[i], sol.productExceptSelf(inputs[i]));
        }
    }
}
