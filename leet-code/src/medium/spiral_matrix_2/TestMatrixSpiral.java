package medium.spiral_matrix_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMatrixSpiral {

    @Test
    public void testMatrix1X1(){
        int n = 1;
        int[][] expected = {{1}};
        int[][] result = new Solution().generateMatrix(n);
        assertTrue(isSameArray(expected, result));
    }
    
    @Test
    public void testMatrix2X2(){
        int n = 2;
        int[][] expected = {{1,2}, {4,3}};
        int[][] result = new Solution().generateMatrix(n);
        assertTrue(isSameArray(expected, result));
    }
    
    @Test
    public void testMatrix3X3(){
        int n = 3;
        int[][] expected = {{1,2,3},{8,9,4},{7,6,5}};
        int[][] result = new Solution().generateMatrix(n);
        assertTrue(isSameArray(expected, result));
    }
    
    @Test
    public void testMatrix4X4(){
        int n = 4;
        int[][] expected = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        int[][] result = new Solution().generateMatrix(n);
        assertTrue(isSameArray(expected, result));
    }
    
    private boolean isSameArray(int[][] arr1, int[][] arr2){
        if(arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i].length != arr2[i].length) {
                return false;
            }
            for (int j = 0; j < arr1.length; j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
