package medium.max_subarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaxSubArray {
    
    @Test
    public void testArrayOneElement(){
        int[] values = {1};
        int expected = 1;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testMaxSingleElementAtBeginning(){
        int[] values = {1,-1,-1,-1,-1};
        int expected = 1;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testMaxSingleElementAtEnd(){
        int[] values = {-1,-1,-1,-1,1};
        int expected = 1;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testIncreasingArray(){
        int[] values = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        int expected = 15;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testDecreasingArray(){
        int[] values = {5,4,3,2,1,0,-1,-2,-3,-4,-5};
        int expected = 15;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testMultipleElementsAtBeginning(){
        int[] values = {1,1,1,1,1,-1,-1,-1,-1,-1};
        int expected = 5;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testMultipleElementsAtEnd(){
        int[] values = {-1,-1,-1,-1,-1,1,1,1,1,1};
        int expected = 5;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testMultipleElementsAtMiddle(){
        int[] values = {-1,-1,-1,-1,-1,1,1,1,1,1,-1,-1,-1,-1,-1};
        int expected = 5;
        assertEquals(expected, new Solution().maxSubArray(values));
    }
    
    @Test
    public void testMultipleGroups(){
        int[] values = {1,2,-5,2,2,2,-1,-1,4,-10, 2,2,-1,-4};
        int expected = 8;
        assertEquals(expected, new Solution().maxSubArray(values));
    }

}
