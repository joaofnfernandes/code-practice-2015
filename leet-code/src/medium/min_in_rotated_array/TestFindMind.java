package medium.min_in_rotated_array;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFindMind {

    @Test
    public void testNoShift(){
        int[] values = {0,1,2,3,4,5};
        int expected = 0;
        assertEquals(expected, new Solution().findMin(values));
    }
    
    @Test
    public void testHalfShiftedEvenArray(){
        int[] values = {3,4,5,0,1,2};
        int expected = 0;
        assertEquals(expected, new Solution().findMin(values));
    }
    
    @Test
    public void testHalfShiftedOddArray(){
        int[] values = {3,4,5,6,0,1,2};
        int expected = 0;
        assertEquals(expected, new Solution().findMin(values));
    }
    
    @Test
    public void testFindMin() {
        int size = 6;
        int expected = 0;
        Solution sol = new Solution();
        
        for (int i = 0; i < size; i++) {
            int[] nums = createArray(size);
            shiftArray(nums, i);
            assertEquals(expected, sol.findMin(nums));
        }
    }
    
    private int[] createArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
    
    // Shifts an array to the right n positions
    private void shiftArray(int[] nums, int n) {
        for (int i = 0; i < nums.length/2; i++) {
            swap(nums, i, nums.length - i - 1);
        }
        for (int i = 0; i < n/2; i++) {
            swap(nums, i, n - i - 1);
        }
        for(int i = n; i < n + (nums.length - n) / 2; i++) {
            swap(nums, i, nums.length - i + n - 1);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
