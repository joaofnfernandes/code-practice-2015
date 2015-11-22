package medium.sort_colors;

/*
 * Uses a 3-way quicksort partition to sort an array with {0,1,2} values
 */
public class Solution {
    public void sortColors(int[] nums) {
        final int pivot = 1;
        int i = 0, eq = 0, j = nums.length - 1;
        while(i <= j) {
            if(nums[i] == pivot) {
                i++;
            } else if(nums[i] < pivot) {
                swap(nums, i++, eq++);
            } else if(nums[j] > pivot) {
                j--;
            } else {
                swap(nums, i, j--);
            }
        }
    }
    
    private void swap(int[] nums, int i , int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
