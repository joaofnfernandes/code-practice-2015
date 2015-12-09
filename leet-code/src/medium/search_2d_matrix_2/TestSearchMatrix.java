package medium.search_2d_matrix_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSearchMatrix {

    @Test
    public void testEmptyMatrix() {
        int[][] matrix = {};
        int[] targetValues = {1,2,3};
        for (int target : targetValues) {
            assertFalse(new Solution().searchMatrix(matrix, target));
        }
    }
    
    @Test
    public void testContains() {
        int[][] matrix = makeTestMatrix();
        int[][] targetValues = makeTestMatrix();
        for (int i = 0; i < targetValues.length; i++) {
            for (int j = 0; j < targetValues[i].length; j++) {
                assertTrue(new Solution().searchMatrix(matrix, targetValues[i][j]));
            }
        }
    }
    
    @Test
    public void testNotContains() {
        int[][] matrix = makeTestMatrix();
        int[] targetValues = {0, 20, 25, 27, 28, 29};
        for (int target : targetValues) {
            assertFalse(new Solution().searchMatrix(matrix, target));
        }
    }
    
    private int[][] makeTestMatrix() {
        return new int[][] {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
    }
}
