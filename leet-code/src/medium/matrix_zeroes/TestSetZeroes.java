package medium.matrix_zeroes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSetZeroes {

    @Test
    public void testNoZeroes() {
        int m = 4, n = 4;
        int[][] matrix = makeDefaulMatrix(m,n);
        new Solution().setZeroes(matrix);
        
        int[][] expected = makeDefaulMatrix(m, n);
        assertTrue(isSameMatrix(expected, matrix));
    }
    
    @Test
    public void testZero00(){
        int n = 4, m = 4;
        int[][] matrix = makeDefaulMatrix(n,m);
        matrix[0][0] = 0;
        new Solution().setZeroes(matrix);
        
        int[][] expected = makeDefaulMatrix(n, m);
        zeroMatrixColumn(expected, 0);
        zeroMatrixRow(expected, 0);
        
        assertTrue(isSameMatrix(expected, matrix));
    }
    
    @Test
    public void testZero0M(){
        int n = 4, m = 4;
        int[][] matrix = makeDefaulMatrix(n,m);
        matrix[0][m - 1] = 0;
        new Solution().setZeroes(matrix);
        
        int[][] expected = makeDefaulMatrix(n, m);
        zeroMatrixColumn(expected, m - 1);
        zeroMatrixRow(expected, 0);
        
        assertTrue(isSameMatrix(expected, matrix));
    }
    
    @Test
    public void testZeroN0(){
        int n = 4, m = 4;
        int[][] matrix = makeDefaulMatrix(n,m);
        matrix[n-1][0] = 0;
        new Solution().setZeroes(matrix);
        
        int[][] expected = makeDefaulMatrix(n, m);
        zeroMatrixColumn(expected, 0);
        zeroMatrixRow(expected, n-1);
        
        assertTrue(isSameMatrix(expected, matrix));
    }
    
    @Test
    public void testZeroNN(){
        int n = 4, m = 4;
        int[][] matrix = makeDefaulMatrix(n,m);
        matrix[n-1][m-1] = 0;
        new Solution().setZeroes(matrix);
        
        int[][] expected = makeDefaulMatrix(n, m);
        zeroMatrixColumn(expected, m-1);
        zeroMatrixRow(expected, n-1);
        
        assertTrue(isSameMatrix(expected, matrix));
    }
    
    @Test
    public void testZeroMidMid(){
        int n = 4, m = 4;
        int[][] matrix = makeDefaulMatrix(n,m);
        matrix[n/2][m/2] = 0;
        new Solution().setZeroes(matrix);
        
        int[][] expected = makeDefaulMatrix(n, m);
        zeroMatrixColumn(expected, m/2);
        zeroMatrixRow(expected, n/2);
        
        assertTrue(isSameMatrix(expected, matrix));
    }
    
    private int[][] makeDefaulMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i * n + j + 1;
            }
        }
        return matrix;
    }
    
    private void zeroMatrixColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
    
    private void zeroMatrixRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
    
    private boolean isSameMatrix(int[][] m1, int[][] m2) {
        if(m1.length != m2.length) {
            return false;
        }
        for (int i = 0; i < m1.length; i++) {
            if(m1[i].length != m2[i].length) {
                return false;
            }
            for (int j = 0; j < m1[i].length; j++) {
                if(m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
