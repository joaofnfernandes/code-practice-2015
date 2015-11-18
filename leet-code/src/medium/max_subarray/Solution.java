package medium.max_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        
        int max = Integer.MIN_VALUE;
        int maxSoFar = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, maxSoFar);
            maxSoFar = Math.max(nums[i], maxSoFar + nums[i]);
        }
        return Math.max(max, maxSoFar);
    }
}