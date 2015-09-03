package chapter9.sorting;

public class Quicksort extends AbstractSort {

	@Override
	public void Sort(int[] nums) {
		if(nums != null) {
			sort(nums, 0, nums.length - 1);
		}
	}
	
	private void sort(int[] nums, int start, int end) {
		if(end - start <= 0) {
			return;
		} else {
			int pivot = quicksort(nums, start, end);
			sort(nums, start, pivot - 1);
			sort(nums, pivot + 1, end);
		}
	}
	
	private int quicksort(int[] nums, int start, int end){
		int pivot = start, i = start + 1, j = end;
		while(i <= j && i <= end && j > start) {
			if(nums[i] < nums[pivot]) {
				i++;
			} else if(nums[j] >= nums[pivot]) {
				j--;
			} else {
				swap(nums, i++, j--);
			}
		}
		swap(nums, pivot, j);
		return j;
	}

}
