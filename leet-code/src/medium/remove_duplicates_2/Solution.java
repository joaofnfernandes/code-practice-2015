package medium.remove_duplicates_2;

// Removes duplicates from a sorted array.
// Allows for at most 1 duplicates
public class Solution {
    // Generic solution that allows for K duplicates
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1) { return 0; }
        final int N = nums.length;
        final int duplicatesAllowed = 2;
        int i = 0, j = 1;
        while(j < N) {
            if(nums[i] != nums[j]) {
                swap(nums, ++i, j++);
            } else {
                int k = j + 1;
                while(k < N && nums[j] == nums[k]) { k++; }
                for (int l = 0; l < duplicatesAllowed - 1; l++) {
                    swap(nums, ++i, j++);
                }
                j = k;
            }
        }
        return i + 1;
    }
    
    // Solution that always allows 2 duplicates
    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length < 1) { return 0; }
        final int N = nums.length;
        int i = 0, j = 1;
        boolean repeated = false;
        while(j < N) {
            if(nums[i] != nums[j]) {
                swap(nums, ++i, j++);
                repeated = false;
            } else {
                if(repeated) {
                    while(j < N && nums[i] == nums[j]) { j++; }
                } else {
                    swap(nums, ++i, j++);
                    repeated = true;
                }
            }
        }
        return i + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}