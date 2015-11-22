package medium.unique_paths;

public class Solution {
    // Dynamic programming solution
    public int uniquePaths(int m, int n) {
        int[][] values = new int[m][n];
        values[0][0] = 0;
        for (int i = 0; i < n; i++) {
            values[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            values[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                values[i][j] = values[i - 1][j] + values[i][j - 1];
            }
        }
        return values[m - 1][n - 1];
    }
    
    // recursive solution
    public int uniquePaths2(int m, int n) {
        return uniquePaths2(0,0, m - 1, n - 1);
    }
    
    private int uniquePaths2(int currX, int currY, int destX, int destY) {
        if(currX > destX) {
            return 0;
        } else if(currY > destY) {
            return 0;
        } else if(currX == destX && currY == destY) {
            return 1;
        } else {
            return uniquePaths2(currX + 1, currY, destX, destY) +
                    uniquePaths2(currX, currY + 1, destX, destY);
        }
    }
}