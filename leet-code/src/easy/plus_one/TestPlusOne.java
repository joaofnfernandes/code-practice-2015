package easy.plus_one;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPlusOne {
    
    @Test
    public void testSingleDigitNoCarry() {
        int[] input = {1};
        int[] expected = {2};
        int[] result = new Solution().plusOne(input);
        assertTrue(isSameArray(expected, result));
    }
    
    @Test
    public void testMultipleDigitsNoCarry() {
        int[] input = {1,1};
        int[] expected = {1,2};
        int[] result = new Solution().plusOne(input);
        assertTrue(isSameArray(expected, result));
    }
    
    
    @Test
    public void testMultipleDigitsCarry1(){
        int[] input = {1,9};
        int[] expected = {2,0};
        int[] result = new Solution().plusOne(input);
        assertTrue(isSameArray(expected, result));
    }
    
    @Test
    public void testSingleDigitCarry(){
        int[] input = {9};
        int[] expected = {1,0};
        int[] result = new Solution().plusOne(input);
        assertTrue(isSameArray(expected, result));
    }
    
    @Test
    public void testMultipleDigitsCarry2() {
        int[] input = {9,9,9};
        int[] expected = {1,0,0,0};
        int[] result = new Solution().plusOne(input);
        assertTrue(isSameArray(expected, result));
    }
    
    
    private boolean isSameArray(int[] d1, int[] d2) {
        if(d1.length != d2.length) {
            return false;
        }
        for (int i = 0; i < d1.length; i++) {
            if(d1[i] != d2[i]) {
                return false;
            }
        }
        return true;
    }

}
