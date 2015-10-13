package majority_element;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMajorityElement {

    @Test
    public void testOneElement(){
        int[] input = {1};
        int expected = 1;
        assertEquals(expected, new Solution().majorityElement(input));
        assertEquals(expected, new Solution().majorityElement2(input));
    }
    
    @Test
    public void testElementsToLeft(){
        int[] input = {0,0,0,0,0,1,2,3,4};
        int expected = 0;
        assertEquals(expected, new Solution().majorityElement(input));
        assertEquals(expected, new Solution().majorityElement2(input));
    }
    
    @Test
    public void testElementsToRight(){
        int[] input = {1,2,3,4,0,0,0,0,0};
        int expected = 0;
        assertEquals(expected, new Solution().majorityElement(input));
        assertEquals(expected, new Solution().majorityElement2(input));
    }
    
    @Test
    public void testElementsInMiddle(){
        int[] input = {1,2,0,0,0,0,0,3,4};
        int expected = 0;
        assertEquals(expected, new Solution().majorityElement(input));
        assertEquals(expected, new Solution().majorityElement2(input));
    }
    
    @Test
    public void testElementsInCorners(){
        int[] input = {1,0,1};
        int expected = 1;
        assertEquals(expected, new Solution().majorityElement(input));
        assertEquals(expected, new Solution().majorityElement2(input));
    }
}
