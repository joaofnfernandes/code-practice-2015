package chapter9.bubbleSort;

public class BubbleSort extends AbstractSort {

	public void Sort(int[] nums) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if(nums[i] > nums[i + 1]) {
					swap(nums, i, i + 1);
					swapped = true;
				}
			}
		} while (swapped);
	}
}
