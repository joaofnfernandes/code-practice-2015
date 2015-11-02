package single_number;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0) {
            return -1;
        } else if(nums.length == 1) {
            return nums[0];
        } else {
            Arrays.sort(nums);
            int i;
            for(i = 0; i < nums.length - 1; i += 2) {
                if(nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            return nums[i];
        }
    }
}