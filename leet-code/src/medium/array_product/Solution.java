package medium.array_product;
/*
 * Returns an array where each position has the result of multiplying
 * all elements except itself.
 * 
 * Does this without division, by using a two-pass approach.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        int aux = 1;
        for (int i = 0; i < solution.length; i++) {
            solution[i] = aux;
            aux *= nums[i];
        }
        aux = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            solution[i] = solution[i] * aux;
            aux *= nums[i];
        }
        return solution;
    }
}