package easy.remove_duplicates;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int start = 0, end = 1;
        while(end < nums.length) {
            if(nums[start] == nums[end]) {
                end++;
            } else {
                start++;
                if(end - start > 0) {
                    swap(nums, start, end);
                }
                end++;
            }
        }
        return start + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
