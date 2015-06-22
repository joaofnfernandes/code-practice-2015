package chapter4.binaryTree;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestBinaryTree {
	
	@Test
	public void TestContains() {
		BinaryTree<Integer> bt = new BinaryTree<>();
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
		BinaryTree<Integer> bt = new BinaryTree<>();
		assertEquals(0, bt.size());
		
		int[] values = new int[] {2,1,3,4,0};
		for(int i = 0; i < values.length; i++) {
			bt.insert(values[i]);
			assertEquals(i + 1, bt.size());
		}
	}
	
	@Test
	public void TestMaxDepth() {
		BinaryTree<Integer> bt = new BinaryTree<>();
				
		int[] values = new int[] {5,4,3,2,1,0};
		for(int i = 0; i < values.length; i++) {
			bt.insert(values[i]);
			assertEquals(i + 1, bt.size());
		}
	}
	
	@Test
	public void TestMin() {
		BinaryTree<Integer> bt = new BinaryTree<>();
				
		int[] values = new int[] {5,4,3,2,1};
		for(int i = 0; i < values.length; i++) {
			bt.insert(values[i]);
			assertEquals(values[i], (int)bt.min());
		}
	}

}
