package easy.remove_arr_elements;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while(i < nums.length) {
            if(nums[i] == val) {
                i++;
            } else {
                swap(nums, i++, j++);
            }
        }
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
