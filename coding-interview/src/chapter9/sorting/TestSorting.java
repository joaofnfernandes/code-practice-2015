package chapter9.sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSorting {
	
	private static final int ARRAY_TEST_SIZE = 10;
	
	@Test
	public void TestBubbleSort() {
		BubbleSort sort = new BubbleSort();
		runAllSortingTests(sort);
		
	}
	
	@Test
	public void TestSelectionSort() {
		SelectionSort sort = new SelectionSort();
		runAllSortingTests(sort);
	}
	
	@Test
	public void TestInsertionSort() {
		InsertionSort sort = new InsertionSort();
		runAllSortingTests(sort);
	}
	
	private void runAllSortingTests(AbstractSort sort) {
		testAlreadySorted(sort);
		test1UnSortedPos0(sort);
		test1UnsortedPosMiddle(sort);
		testShuffled(sort);
	}
	
	
	private void testAlreadySorted(AbstractSort sort) {
		int[] arr = makeSortedArray(ARRAY_TEST_SIZE);
		
		sort.Sort(arr);
		assertTrue(isSorted(arr));
	}
	
	
	private void test1UnSortedPos0(AbstractSort sort) {
		int[] arr = makeSortedArray(ARRAY_TEST_SIZE);
		sort.swap(arr, 0, arr.length - 1);
		
		sort.Sort(arr);
		assertTrue(isSorted(arr));
	}
	
	private void test1UnsortedPosMiddle(AbstractSort sort) {
		int[] arr = makeSortedArray(ARRAY_TEST_SIZE);
		sort.swap(arr, 0, arr.length / 2);
		
		sort.Sort(arr);
		assertTrue(isSorted(arr));
	}
	
	private void testShuffled(AbstractSort sort) {
		int[] arr = makeSortedArray(ARRAY_TEST_SIZE);
		int randomIndex;
		for (int i = 0; i < arr.length; i++) {
			randomIndex = (int)((arr.length - 1) * Math.random());
			sort.swap(arr, i, randomIndex);
		}
		
		sort.Sort(arr);
		assertTrue(isSorted(arr));
	}
	
	private boolean isSorted(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	private int[] makeSortedArray(int N) {
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}
}
