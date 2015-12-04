package medium.valid_sudoku;

// validates if a 9X9 sudoku board is valid
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9) {
            return false;
        }
        int N = board.length;
        boolean[][] lineValues = new boolean[N][N];
        boolean[][] columnValues = new boolean[N][N];
        boolean[][] squareValues = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] != '.') {
                    if(lineValues[i][board[i][j] - '1']) {
                        return false;
                    } else {
                        lineValues[i][board[i][j] - '1'] = true;
                    }
                    if(columnValues[j][board[i][j] - '1']) {
                        return false;
                    } else {
                        columnValues[j][board[i][j] - '1'] = true;
                    }
                    if (squareValues[3 * (i/3) + (j/3)][board[i][j] - '1']) {
                        return false;
                    } else {
                        squareValues[3 * (i/3) + (j/3)][board[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}