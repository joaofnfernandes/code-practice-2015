package zeroMatrix;

import org.junit.Test;
import static org.junit.Assert.*;
import static zeroMatrix.ZeroMatrix.*;

public class TestZeroMatrix {
	
	@Test
	public void TestZeroMatrixOnLeft() {
		int[][] input = {
				{0,1,2},
				{3,4,5},
				{6,7,8}
		};
		
		int[][] expected = {
				{0,0,0},
				{0,4,5},
				{0,7,8}
		};
		zero(input);
		assertTrue(equals(expected, input));
	}
	
	@Test
	public void TestZeroMatrixOnMiddle() {
		int[][] input = {
				{1,2,3},
				{4,0,6},
				{7,8,9}
		};
		
		int[][] expected = {
				{1,0,3},
				{0,0,0},
				{7,0,9}
		};
		zero(input);
		assertTrue(equals(expected, input));
	}
	
	@Test
	public void TestZeroMatrixAllZeros() {
		int[][] input = {
				{0,2,3},
				{0,5,6},
				{0,8,9}
		};
		
		int[][] expected = {
				{0,0,0},
				{0,0,0},
				{0,0,0}
		};
		zero(input);
		assertTrue(equals(expected, input));
	}
	
	private boolean equals(int[][] m1, int[][] m2) {
		if(m1 == null || m2 == null || m1.length != m2.length) {
			return false;
		}
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1.length; j++) {
				if(m1[i][j] != m2[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
