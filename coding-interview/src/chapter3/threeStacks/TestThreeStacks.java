package chapter3.threeStacks;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestThreeStacks {
	
	@Test
	public void TestFillStack1() {
		int[] values = new int[10];
		ThreeStacks<Integer> ints = new ThreeStacks<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			values[i] = i;
			ints.push(StackNumber.ONE, i);
		}
		
		for(int i = values.length - 1; i >= 0; i--) {
			assertEquals(values[i], (int)ints.pop(StackNumber.ONE));
			assertNull(ints.pop(StackNumber.TWO));
			assertNull(ints.pop(StackNumber.THREE));
			
		}
	}
	
	@Test
	public void TestFillStack2() {
		int[] values = new int[10];
		ThreeStacks<Integer> ints = new ThreeStacks<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			values[i] = i;
			ints.push(StackNumber.TWO, i);
		}
		
		for(int i = values.length - 1; i >= 0; i--) {
			assertEquals(values[i], (int)ints.pop(StackNumber.TWO));
			assertNull(ints.pop(StackNumber.ONE));
			assertNull(ints.pop(StackNumber.THREE));
		}
	}
	
	@Test
	public void TestFillStack3() {
		int[] values = new int[10];
		ThreeStacks<Integer> ints = new ThreeStacks<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			values[i] = i;
			ints.push(StackNumber.THREE, i);
		}
		
		for(int i = values.length - 1; i >= 0; i--) {
			assertEquals(values[i], (int)ints.pop(StackNumber.THREE));
			assertNull(ints.pop(StackNumber.ONE));
			assertNull(ints.pop(StackNumber.TWO));
		}
	}
	
	@Test
	public void TestFillTwoStacks() {
		int[] values = new int[5];
		ThreeStacks<Integer> ints = new ThreeStacks<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			values[i] = i;
			ints.push(StackNumber.ONE, i);
			ints.push(StackNumber.TWO, i);
		}
		
		for(int i = values.length - 1; i >= 0; i--) {
			assertEquals(values[i], (int)ints.pop(StackNumber.ONE));
			assertEquals(values[i], (int)ints.pop(StackNumber.TWO));
		}
	}
	
	@Test
	public void TestFillThreeStacks() {
		int[] values = new int[3];
		ThreeStacks<Integer> ints = new ThreeStacks<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			values[i] = i;
			ints.push(StackNumber.ONE, i);
			ints.push(StackNumber.TWO, i);
			ints.push(StackNumber.THREE, i);
		}
		
		for(int i = values.length - 1; i >= 0; i--) {
			assertEquals(values[i], (int)ints.pop(StackNumber.ONE));
			assertEquals(values[i], (int)ints.pop(StackNumber.TWO));
			assertEquals(values[i], (int)ints.pop(StackNumber.THREE));
		}
	}

}
