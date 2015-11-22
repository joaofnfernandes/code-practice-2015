package medium.search_insert_position;

/*
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int min = 0, max = nums.length - 1;
        int mid;
        while(min <= max) {
            mid = min + (max - min) / 2;
            if(nums[mid] < target) {
                min = mid + 1;
            } else if(nums[mid] > target) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return min;
    }
}