package rotate_array;

public class Solution {
    // solution with aux array
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) {
            return;
        }
        int[] aux = new int[k];
        for (int i = 0; i < k; i++) {
            aux[i] = nums[nums.length - k + i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = aux[i];
        }
    }
    
    // slow bublesort-like solution
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) {
            return;
        }
        for (int i = k; i < nums.length; i++) {
            for (int j = i; j > i - k; j--) {
                swap(nums, j-1, j);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}