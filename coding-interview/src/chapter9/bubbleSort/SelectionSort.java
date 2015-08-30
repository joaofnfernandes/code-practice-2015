package chapter9.bubbleSort;

public class SelectionSort extends AbstractSort {

	@Override
	public void Sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[min] > nums[j]) {
					min = j;
				}
			}
			swap(nums, i, min);
		}
		
	}

}
