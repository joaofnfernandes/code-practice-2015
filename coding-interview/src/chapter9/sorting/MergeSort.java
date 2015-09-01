package chapter9.sorting;

public class MergeSort {
	
	public static int[] Sort(int[] nums) {
		if(nums == null) {
			return null;
		} else {
			int[] left = copyLeftHalf(nums);
			int[] right = copyRightHalf(nums);
			return sort(left, right);
		}
	}
	
	private static int[] sort(int[] left, int[] right) {
		if(left != null && right == null) {
			return left;
		} else if(left == null && right != null) {
			return right;
		} else if(left.length == 1 && right.length == 1) {
			return merge(left, right);
		} else {
			left = sort(copyLeftHalf(left), copyRightHalf(left));
			right = sort(copyLeftHalf(right), copyRightHalf(right));
			return merge(left, right);
		}
	}
	
	public static void SortInPlace(int[] nums) {
		int hi = nums.length - 1;
		sortInPlace(nums, 0, hi/2, hi);
	}
	
	private static void sortInPlace(int[] nums, int low, int mid, int hi) {
		if(nums == null) {
			return;
		} else if(mid == hi) {
			inPlaceMerge(nums, low, mid, hi);
			return;
		} else {
			sortInPlace(nums, low, (mid - low) / 2, mid);
			sortInPlace(nums, mid, (hi - mid) / 2, hi);
		}
	}
	
	
	private static int[] copyLeftHalf(int[] nums) {
		int[] left = new int[nums.length / 2];
		for (int i = 0; i < left.length; i++) {
			left[i] = nums[i];
		}
		return left;
	}
	
	private static int[] copyRightHalf(int[] nums) {
		int[] right = new int[nums.length / 2];
		for (int i = 0; i < right.length; i++) {
			right[i] = nums[nums.length / 2 + i];
		}
		return right;
	}

	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		
		while(i < result.length) {
			if(j == left.length) {
				result[i++] = right[k++];
			} else if(k == right.length) {
				result[i++] = left[j++];
			} else {
				if(left[j] < right[k]) {
					result[i++] = left[j++];
				} else {
					result[i++] = right[k++];
				}
			}
		}
		return result;
	}
	

	public static void inPlaceMerge(int[] nums, int start, int middle, int end) {
		int i = middle;
		while(start < end) {
			if(nums[start] > nums[i]) {
				swap(nums, start, i);
				if(i < end ) {
					if(nums[i] > nums[i + 1]) {
						i++;
					}
				} else {
					i = middle;
				}
			}
			start++;
			if(start >= i) {
				i = start + 1;
			}
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int aux = nums[i];
		nums[i] = nums[j];
		nums[j] = aux;
	}

}
