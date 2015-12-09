package medium.search_2d_matrix_2;
/*
 * Searches for a value in a matrix with the following properties
 *  - each row is sorted
 *  - each column is sorted
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1){ return false;}
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0) {
            int value = matrix[i][j];
            if(value == target) { return true;}
            else if(value > target) { j--; }
            else { i++; }
        }
        return false;
    }
}