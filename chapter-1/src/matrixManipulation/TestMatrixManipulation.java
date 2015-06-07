package matrixManipulation;

import org.junit.Ignore;
import org.junit.Test;

import static matrixManipulation.MatrixManipulation.*;
import static org.junit.Assert.*;

public class TestMatrixManipulation {
	
	@Test
	public void TestRotateRight90Degrees() {
		int[][]  matrix = {
				{0,1,2},
				{3,4,5},
				{6,7,8}
		};
		
		int[][] expected = {
				{6,3,0},
				{7,4,1},
				{8,5,2}
		};
		rotate90Right(matrix);
		assertTrue((boolean)equals(matrix, expected));		
	}
	
	@Test
	public void TestRotateLeft90Degrees() {
		int[][]  matrix = {
				{0,1,2},
				{3,4,5},
				{6,7,8}
		};
		
		int[][] expected = {
				{2,5,8},
				{1,4,7},
				{0,3,6}
		};
		rotate90Left(matrix);
		assertTrue((boolean)equals(matrix, expected));		
	}
	
	private boolean equals(int[][] m, int[][] n) {
		if(m.length != n.length) {
			return false;
		}
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length; j++) {
				if(m[i][j] != n[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
