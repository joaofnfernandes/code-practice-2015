package medium.remove_duplicates_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemoveDuplicates {

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int expected = 0;
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected, result);
    }
    
    @Test
    public void testNoDuplicates(){
        int[] nums = {1,2,3,4,5};
        int[] expected = {1,2,3,4,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testAllowedDuplicatesOnHead(){
        int[] nums = {1,1,2,3,4,5};
        int[] expected = {1,1,2,3,4,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testAllowedDuplicatesOnMid(){
        int[] nums = {1,2,3,3,4,5};
        int[] expected = {1,2,3,3,4,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testAllowedDuplicatesOnTail(){
        int[] nums = {1,2,3,4,5,5};
        int[] expected = {1,2,3,4,5,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testAllAllowedDuplicates() {
        int[] nums = {1,1,2,2,3,3,4,4,5,5};
        int[] expected = {1,1,2,2,3,3,4,4,5,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testNotAllowedDuplicatedOnHead(){
        int[] nums = {1,1,1,2,3,4,5};
        int[] expected = {1,1,2,3,4,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testNotAllowedDuplicatedOnMid(){
        int[] nums = {1,2,3,3,3,4,5};
        int[] expected = {1,2,3,3,4,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testNotAllowedDuplicatesOnTail(){
        int[] nums = {1,2,3,4,5,5,5};
        int[] expected = {1,2,3,4,5,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testAllNotAllowedDuplicates(){
        int[] nums = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5};
        int[] expected = {1,1,2,2,3,3,4,4,5,5};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
    @Test
    public void testIntermixedDuplicates() {
        int[] nums = {1,1,1,2,3,3,4,4,4,5,5,5,6};
        int[] expected = {1,1,2,3,3,4,4,5,5,6};
        int result = new Solution().removeDuplicates(nums);
        assertEquals(expected.length, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], nums[i]);
        }
    }
    
}
