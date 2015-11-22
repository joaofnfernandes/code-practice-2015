package medium.peak_element;

public class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0;
        while(i < nums.length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        return i;
    }
}
