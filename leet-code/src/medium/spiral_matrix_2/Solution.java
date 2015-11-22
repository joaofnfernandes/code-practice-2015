package medium.spiral_matrix_2;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int leftBound = 0, topBound = 0, rightBound = n-1, bottomBound = n-1;
        int value = 1;
        
        while(leftBound <= rightBound &&
                topBound <= bottomBound) {
            //left->right
            for (int i = leftBound; i <= rightBound; i++) {
                matrix[topBound][i] = value++;
            }
            topBound++;
            // top->bottom
            for (int i = topBound; i <= bottomBound; i++) {
                matrix[i][rightBound] = value++;
            }
            rightBound--;
            //left->right
            for (int i = rightBound; i >= leftBound; i--) {
                matrix[bottomBound][i] = value++;
            }
            bottomBound--;
            // bottom->top
            for (int i = bottomBound; i >= topBound; i--) {
                matrix[i][leftBound] = value++;
            }
            leftBound++;
        }
        return matrix;
    }
}