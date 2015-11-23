package medium.search_2d_matrix;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestSearchMatrix {
    
    @Test
    public void testMatch00(){
        int[][] matrix = makeAscendingMatrix();
        int i = 0, j = 0;
        int value = matrix[i][j];
        assertTrue(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testMatch0N(){
        int[][] matrix = makeAscendingMatrix();
        int i = 0, j = 3;
        int value = matrix[i][j];
        assertTrue(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testMatchN0(){
        int[][] matrix = makeAscendingMatrix();
        int i = 2, j = 3;
        int value = matrix[i][j];
        assertTrue(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testMatchNN(){
        int[][] matrix = makeAscendingMatrix();
        int i = 2, j = 3;
        int value = matrix[i][j];
        assertTrue(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testMatchMid0(){
        int[][] matrix = makeAscendingMatrix();
        int i = 1, j = 0;
        int value = matrix[i][j];
        assertTrue(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testMatchMidMid(){
        int[][] matrix = makeAscendingMatrix();
        int i = 1, j = 1;
        int value = matrix[i][j];
        assertTrue(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testNoMatch00(){
        int[][] matrix = makeAscendingMatrix();
        int value = 0;
        assertFalse(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testNoMatch0N(){
        int[][] matrix = makeAscendingMatrix();
        int value = 8;
        assertFalse(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testNoMatchN0(){
        int[][] matrix = makeAscendingMatrix();
        int value = 22;
        assertFalse(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testNoMatchNN(){
        int[][] matrix = makeAscendingMatrix();
        int value = 100;
        assertFalse(new Solution().searchMatrix(matrix, value));
    }
    
    @Test
    public void testNoMatchMidMid(){
        int[][] matrix = makeAscendingMatrix();
        int value = 15;
        assertFalse(new Solution().searchMatrix(matrix, value));
    }
    
    private int[][] makeAscendingMatrix() {
        return new int[][] {{1,   3,  5,  7},
                            {10, 11, 16, 20},
                            {23, 30, 34, 50}};
    }

}
