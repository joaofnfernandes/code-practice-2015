package house_robber;

public class Solution {
    public int rob(int[] nums) {
        int evensSum = 0, oddsSum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            evensSum += nums[i];
        }
        for (int i = 1; i < nums.length; i += 2) {
            oddsSum += nums[i];
        }
        return Math.max(evensSum, oddsSum);
    }
}
