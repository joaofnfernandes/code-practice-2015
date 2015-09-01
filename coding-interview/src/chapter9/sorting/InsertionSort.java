package chapter9.sorting;

public class InsertionSort extends AbstractSort{

	@Override
	public void Sort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j > 0; j--) {
				if(nums[j] < nums[j - 1]) {
					swap(nums, j, j - 1);
				} else {
					break;
				}
			}
		}
		
	}

}
