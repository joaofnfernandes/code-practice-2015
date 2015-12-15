package medium.find_k_largest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFindKLargest {

    @Test
    public void testEmptyArray() {
        final int[] nums = {};
        final int K = 1;
        final int expected = -1;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testK0() {
        final int[] nums = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        final int K = 0;
        final int expected = -1;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortedAscArrayK1(){
        final int[] nums = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        final int K = 1;
        final int expected = 5;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortedAscArrayKN(){
        final int[] nums = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        final int K = nums.length;
        final int expected = -5;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortedAscArrayKMid(){
        final int[] nums = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        final int K = nums.length / 2;
        final int expected = 1;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortedDescArrayK1(){
        int[] nums = {5,4,3,2,1,0,-1,-2,-3,-4,-5};
        final int K = 1;
        final int expected = 5;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortedDescArrayKN(){
        int[] nums = {5,4,3,2,1,0,-1,-2,-3,-4,-5};
        final int K = nums.length;
        final int expected = -5;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortedDescArrayKMid(){
        int[] nums = {5,4,3,2,1,0,-1,-2,-3,-4,-5};
        final int K = nums.length / 2;
        final int expected = 1;
        int result = new Solution().findKthLargest(nums, K);
        assertEquals(expected, result);
    }
    
    @Test
    public void testUnsortedArrayK1(){
        int[][] nums = {{5},{-3,5,4},{1,2,5,4,3,-1}};
        final int K = 1;
        final int expected = 5;
        int result;
        for (int i = 0; i < nums.length; i++) {
            result = new Solution().findKthLargest(nums[i], K);
            assertEquals(expected, result);
        }
        
    }
    
    @Test
    public void testUnsortedArrayKN(){
        int[][] nums = {{5},{-3,5,4},{1,2,5,4,3,-1}};
        int[] expected = {5,-3,-1};
        int K, result;
        
        for (int i = 0; i < nums.length; i++) {
            K = nums[i].length;
            result = new Solution().findKthLargest(nums[i], K);
            assertEquals(expected[i], result);
        }
    }
    
    @Test
    public void testUnsortedArrayKMid(){
        int[][] nums = {{-3,5,4,1},{1,2,5,4,3,-1}};
        int[] expected = {4,3};
        int K, result;
        
        for (int i = 0; i < nums.length; i++) {
            K = nums[i].length / 2;
            result = new Solution().findKthLargest(nums[i], K);
            assertEquals(expected[i], result);
        }
    }
    
}
