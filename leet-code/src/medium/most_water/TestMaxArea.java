package medium.most_water;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaxArea {

    @Test
    public void testIncreasingHeights() {
        int[] heights = {0,1,2,3,4,5,6};
        int expected = 9;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
    @Test
    public void testDecreasingHeights() {
        int[] heights = {6,5,4,3,2,1};
        int expected = 9;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
    @Test
    public void testEndsAreHighest(){
        int[] heights = {5,1,1,1,1,5};
        int expected = 25;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
    @Test
    public void testMiddleIsHighest() {
        int[] heights = {1,1,5,1,5,1};
        int expected = 10;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
    @Test
    public void testDecreaseIncreaseHeights() {
        int[] heights = {6,5,4,3,2,1,1,2,3,4,5,6};
        int expected = 66;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
    @Test
    public void testIncreaseDecreaseHeights() {
        int[] heights = {1,2,3,4,5,6,6,5,4,3,2,1};
        int expected = 21;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
    @Test
    public void testConstantHeights() {
        int[] heights = {5,5,5,5,5,5};
        int expected = 25;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
    @Test
    public void testFlatLand() {
        int[] heights = {1,2,3,4,5,5,5,5,4,3,2,1};
        int expected = 21;
        int result = new Solution().maxArea(heights);
        assertEquals(expected, result);
    }
    
}
