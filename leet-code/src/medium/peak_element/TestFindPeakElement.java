package medium.peak_element;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFindPeakElement {

    @Test
    public void testIncreasing() {
        int[] values = {1,2,3,4,5};
        int expected = 4;
        int result = new Solution().findPeakElement(values);
        assertEquals(expected, result);
    }
    
    @Test
    public void testDecreasing() {
        int[] values = {5,4,3,2,1};
        int expected = 0;
        int result = new Solution().findPeakElement(values);
        assertEquals(expected, result);
    }
    
    @Test
    public void testIncreaseDecrease() {
        int[] values = {1,2,3,4,5,4,3,2,1};
        int expected = 4;
        int result = new Solution().findPeakElement(values);
        assertEquals(expected, result);
    }
    
    @Test
    public void testDecreaseIncrease() {
        int[] values = {5,4,3,2,1,2,3,4,5};
        int expected = 0;
        int result = new Solution().findPeakElement(values);
        assertEquals(expected, result);
    }
}
