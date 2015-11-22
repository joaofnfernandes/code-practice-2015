package medium.rotate_image;

public class Solution {
    public void rotate(int[][] matrix) {
        flipDiagonal(matrix);
        flipVertical(matrix);
        
    }
    
    public void flipDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    public void flipVertical(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                swap(matrix, i, j, i,matrix[i].length - j - 1);
            }
        }
    }
    
    public void swap(int[][] matrix, int i, int j, int x, int y) {
        int aux = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = aux;
    }
}