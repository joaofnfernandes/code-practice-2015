package chapter9.sorting;

public abstract class AbstractSort {

	public abstract void Sort(int[] nums);
	
	protected void swap(int[] nums, int i, int j) {
		int aux = nums[i];
		nums[i] = nums[j];
		nums[j] = aux;
	}
}
