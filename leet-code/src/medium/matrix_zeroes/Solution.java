package medium.matrix_zeroes;

public class Solution {
    // Solution needs to transverse matrix twice -> 2O(N^2)
    // This solution also needs M+N extra space. We could use
    // the first row and column as aux vars, to save that space
    public void setZeroes(int[][] matrix) {
        // aux arrays to store where zeroes are located
        boolean[] col = new boolean[matrix.length];
        boolean[] row = new boolean[matrix[0].length];
        
        // fill-in aux arrays
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }
        // use aux arrays to update matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(col[i] || row[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}