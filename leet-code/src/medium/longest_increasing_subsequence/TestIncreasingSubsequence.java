package medium.longest_increasing_subsequence;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIncreasingSubsequence {

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int expected = 0;
        int result = new Solution().lengthOfLIS(nums);
        assertEquals(expected, result);
    }
    
    @Test
    public void testIncreasingArray() {
        int[] nums = {1,2,3,4,5};
        int expected = 5;
        int result = new Solution().lengthOfLIS(nums);
        assertEquals(expected, result);
    }
    
    @Test
    public void testDecreasingArray() {
        int[] nums = {5,4,3,2,1};
        int expected = 1;
        int result = new Solution().lengthOfLIS(nums);
        assertEquals(expected, result);
    }
    
    @Test
    public void testValley() {
        int[] nums = {5,4,3,2,1,1,1,2,3,4,5};
        int expected = 5;
        int result = new Solution().lengthOfLIS(nums);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPlateau() {
        int[] nums = {1,2,3,4,5,5,5,4,3,2,1};
        int expected = 5;
        int result = new Solution().lengthOfLIS(nums);
        assertEquals(expected, result);
    }
    
    @Test
    public void testWithLocalMaxima1() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int expected = 4;
        int result = new Solution().lengthOfLIS(nums);
        assertEquals(expected, result);
    }
    
    @Test
    public void testWithLocalMaxima2() {
        int[] nums = {20,30,10,2,4,100,90,1,3,5,0};
        int expected = 3;
        int result = new Solution().lengthOfLIS(nums);
        assertEquals(expected, result);
    }
}
