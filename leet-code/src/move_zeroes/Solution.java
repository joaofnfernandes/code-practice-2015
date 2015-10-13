package move_zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int start = 0, end = 0;
        while(end < nums.length) {
            if(nums[end] == 0) {
                swap(nums, start, end++);
            } else {
                swap(nums, start++, end++);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}