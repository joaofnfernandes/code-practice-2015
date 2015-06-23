package chapter4.binarySearchTree;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBinarySearchTree {
	
	@Test
	public void TestContains() {
		BinarySearchTree<Integer> bt = new BinarySearchTree<>();
		assertFalse(bt.contains(0));
		
		int[] values = new int[] {1,0,2};
		for(int i = 0; i < values.length; i++) {
			bt.insert(values[i]);
		}
		
		for(int i = 0; i < values.length; i++) {
			assertTrue(bt.contains(values[i]));
		}
	}
	
	@Test
	public void TestSize() {
		BinarySearchTree<Integer> bt = new BinarySearchTree<>();
		assertEquals(0, bt.size());
		
		int[] values = new int[] {2,1,3,4,0};
		for(int i = 0; i < values.length; i++) {
			bt.insert(values[i]);
			assertEquals(i + 1, bt.size());
		}
	}
	
	@Test
	public void TestMaxDepth() {
		BinarySearchTree<Integer> bt = new BinarySearchTree<>();
				
		int[] values = new int[] {5,4,3,2,1,0};
		for(int i = 0; i < values.length; i++) {
			bt.insert(values[i]);
			assertEquals(i + 1, bt.size());
		}
	}
	
	@Test
	public void TestMin() {
		BinarySearchTree<Integer> bt = new BinarySearchTree<>();
				
		int[] values = new int[] {5,4,3,2,1};
		for(int i = 0; i < values.length; i++) {
			bt.insert(values[i]);
			assertEquals(values[i], (int)bt.min());
		}
	}

}
