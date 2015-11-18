package medium.single_numer_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSingleNumber {

    @Test
    public void testSortedArraySingleNumberOnLeft(){
        int[] values = {15,1,1,1,2,2,2,3,3,3,4,4,4};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testSortedArraySingleNumberOnRight(){
        int[] values = {1,1,1,2,2,2,3,3,3,4,4,4,15};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testSortedArraySingleNumberOnMiddle(){
        int[] values = {1,1,1,2,2,15,2,3,3,3,4,4,4};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testUnsortedArraySingleNumberOnLeft(){
        int[] values = {15,1,2,3,1,2,3,1,2,3};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testUnsortedArraySingleNumberOnRight(){
        int[] values = {1,2,3,1,2,3,1,2,3,15};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testUnsortedArraySingleNumberOnMiddle(){
        int[] values = {1,2,3,1,15,2,3,1,2,3};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testSingleValueIsZero(){
        int[] values = {1,2,3,0,1,2,3,1,2,3};
        int expected = 0;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testSingleNumberIsNegative() {
        int[] values = {1,2,3,1,-15,2,3,1,2,3};
        int expected = -15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testAllNumbersAreNegative() {
        int[] values = {-1,-2,-3,-1,-15,-2,-3,-1,-2,-3};
        int expected = -15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testOnlySingleValue(){
        int[] values = {15};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
    
    @Test
    public void testForOverflows(){
        int[] values = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                        15,
                        Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int expected = 15;
        assertEquals(expected, new Solution().singleNumber(values));
    }
}
