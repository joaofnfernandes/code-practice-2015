package chapter9.sorting;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMerge {
	
	@Test
	public void TestMergeAuxStructure() {
		TestLeftSmaller();
		TestLeftSmaller2();
		TestRightSmaller();
		TestRightSmaller2();
		TestInterleaved();
		TestInterleaved2();
	}
	
	@Test
	public void TestMergeInPlace() {
		TestLeftSmallerInPlace();
		TestLeftSmaller2InPlace();
		TestRightSmallerInPlace();
		TestRightSmaller2InPlace();
		TestInterleavedInPlace();
		TestInterleaved2InPlace();
	}
	
	@Test
	public void TestMergeSort() {
		TestSortedArray();
		TestArrayUnsortedElem0();
		TestShuffledArray();
		
	}
	
	public void TestSortedArray() {
		int[] expected = new int[]{1,2,3,4};
		int[] result = new int[]{1,2,3,4};
		result = MergeSort.Sort(result);
		assertArrayEquals(expected, result);
	}
	
	public void TestArrayUnsortedElem0() {
		int[] expected = new int[]{1,2,3,4};
		int[] result = new int[]{4,2,3,1};
		result = MergeSort.Sort(result);
		assertArrayEquals(expected, result);
	}
	
	public void TestShuffledArray() {
		int[] expected = new int[]{1,2,3,4};
		int[] result = new int[]{1,4,2,3};
		result = MergeSort.Sort(result);
		assertArrayEquals(expected, result);
	}
	
	private void TestLeftSmaller() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] left = new int[] {1,2};
		int[] right = new int[] {3,4,5};
		int[] result = MergeSort.merge(left, right);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestLeftSmallerInPlace() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] result = new int[] {1,2,3,4,5};
		MergeSort.inPlaceMerge(result, 0, 2, 4);
		
		assertArrayEquals(expected, result);
	}
	

	private void TestLeftSmaller2() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] left = new int[] {1,2,3};
		int[] right = new int[] {4,5};
		int[] result = MergeSort.merge(left, right);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestLeftSmaller2InPlace() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] result = new int[] {1,2,3,4,5};
		MergeSort.inPlaceMerge(result, 0, 3, 4);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestRightSmaller() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] left = new int[] {4,5};
		int[] right = new int[] {1,2,3};
		int[] result = MergeSort.merge(left, right);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestRightSmallerInPlace() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] result = new int[] {4,5,1,2,3};
		MergeSort.inPlaceMerge(result, 0, 2, 4);
		
		assertArrayEquals(expected, result);
	}
	
	
	private void TestRightSmaller2() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] left = new int[] {3,4,5};
		int[] right = new int[] {1,2};
		int[] result = MergeSort.merge(left, right);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestRightSmaller2InPlace() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] result = new int[] {3,4,5,1,2};
		MergeSort.inPlaceMerge(result, 0, 3, 4);
		
		assertArrayEquals(expected, result);
	}
	
	
	private void TestInterleaved() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] left = new int[] {1,3};
		int[] right = new int[] {2,4,5};
		int[] result = MergeSort.merge(left, right);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestInterleavedInPlace() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] result = new int[] {1,3,2,4,5};
		MergeSort.inPlaceMerge(result, 0, 2, 4);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestInterleaved2() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] left = new int[] {2,5};
		int[] right = new int[] {1,3,4};
		int[] result = MergeSort.merge(left, right);
		
		assertArrayEquals(expected, result);
	}
	
	private void TestInterleaved2InPlace() {
		int[] expected = new int[] {1,2,3,4,5};
		
		int[] result = new int[] {2,5,1,3,4};
		MergeSort.inPlaceMerge(result, 0, 2, 4);
		
		assertArrayEquals(expected, result);
	}
}
