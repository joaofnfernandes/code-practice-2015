package house_robber;

public class Solution {
    
    public int rob(int[] nums) {
        int l2 = 0, l1 = 0, current = 0;
        for (int n : nums) {
            current = Math.max(l1, l2 + n);
            l2 = l1;
            l1 = current;
        }
        return current;
    }
    
    // Recursive solution
    public int rob2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
            return rob(nums, 0);
        }
    }
    
    public int rob(int[] nums, int i) {
        if(i >= nums.length) { 
            return 0;
        } else {
            // explore path where you use number, and where you don't
            return Math.max(nums[i] + rob(nums, i + 2), rob(nums, i + 1));
        }
    }
}
