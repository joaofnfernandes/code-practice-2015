package medium.min_in_rotated_array;

/*
 * Finds the min element in a sorted array that has been shifted.
 * Uses a binary-search approch
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] < nums[right]) {
                return nums[left];
            } else {
                int mid = left + (right - left) / 2;
                if(nums[left] < nums [mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                    left++;
                }
            }
        }
        return nums[left];
    }
}
