package medium.missing_number;

/*
 * Finds the missing number in an array of [0,1,2,...,n]
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int indexes = 0, values = 0;
        for (int i = 0; i < nums.length; i++) {
            indexes += i + 1;
            values += nums[i];
        }
        return indexes - values;
    }
}