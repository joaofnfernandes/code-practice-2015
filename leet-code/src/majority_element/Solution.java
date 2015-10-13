package majority_element;

import java.util.Arrays;

public class Solution {
    // O(N) solution
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if(num == candidate) {
                count++;
            } else {
                if(count > 0) {
                    count--;
                } else {
                    candidate = num;
                    count = 1;
                }
            }
        }
        return candidate;
    }
    
    // Nlog(N) solution
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = 0;
        while(end < nums.length) {
            if(nums[start] == nums[end]) {
                end++;
            } else {
                if(end - start > nums.length / 2) {
                    return nums[start];
                }
                start = end;
            }
        }
        return nums[start];
    }
}
