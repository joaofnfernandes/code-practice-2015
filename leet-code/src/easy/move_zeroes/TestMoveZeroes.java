package easy.move_zeroes;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestMoveZeroes {

    @Test
    public void testOneValue() {
        int[] input = {0,0,1,0,0};
        int[] expected = {1,0,0,0,0};
        
        new Solution().moveZeroes(input);
        assertTrue(Arrays.equals(expected, input));
    }
    
    @Test
    public void testOneZero() {
        int[] input = {1,2,0,3,4};
        int[] expected = {1,2,3,4,0};
        
        new Solution().moveZeroes(input);
        assertTrue(Arrays.equals(expected, input));
    }
    
    @Test
    public void testMultipleZeroes() {
        int[] input = {0,1,0,2,0,3,0};
        int[] expected = {1,2,3,0,0,0,0};
        
        new Solution().moveZeroes(input);
        assertTrue(Arrays.equals(expected, input));
    }
    
}
