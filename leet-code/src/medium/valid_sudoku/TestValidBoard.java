package medium.valid_sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestValidBoard {

    @Test
    public void TestInvalidRows(){
        final int boardSize = 9;
        final int[][] duplicateCells = {{0,1}, {0,2}, {0,8}, {7,8}, {3,4}, {1,2,3}, {6,7,8}};
        final char value = '5';
        
        char[][] board;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < duplicateCells.length; j++) {
                board = makeEmpty9x9Board();
                for (int k = 0; k < duplicateCells[j].length; k++) {
                    board[i][duplicateCells[j][k]] = value;
                }
                assertFalse(new Solution().isValidSudoku(board));
            }
        }
    }
    
    @Test
    public void TestInvalidColumns(){
        final int boardSize = 9;
        final int[][] duplicateCells = {{0,1}, {0,2}, {0,8}, {7,8}, {3,4}, {1,2,3}, {6,7,8}};
        final char value = '5';
        
        char[][] board;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < duplicateCells.length; j++) {
                board = makeEmpty9x9Board();
                for (int k = 0; k < duplicateCells[j].length; k++) {
                    board[duplicateCells[j][k]][i] = value;
                }
                assertFalse(new Solution().isValidSudoku(board));
            }
        }
    }
    
    @Test
    public void TestInvalidSquares(){
        final int boardSize = 9;
        final char value = '5';
        
        char[][] board;
        for (int i = 0; i < boardSize; i+=3) {
            for (int j = 0; j < boardSize; j+=3) {
                board = makeEmpty9x9Board();
                // right diagonal inside square
                board[0 + i][0 + j] = value;
                board[1 + i][1 + j] = value;
                board[2 + i][2 + j] = value;
                assertFalse(new Solution().isValidSudoku(board));
                
                board = makeEmpty9x9Board();
                // left diagonal inside square
                board[0 + i][2 + j] = value;
                board[1 + i][1 + j] = value;
                board[2 + i][0 + j] = value;
            }
        }
    }
    
    @Test
    public void TestEmptyBoard(){
        char[][] board = makeEmpty9x9Board();
        assertTrue(new Solution().isValidSudoku(board));
    }
    
    @Test
    public void TestBoardIsValid() {
        char[][] board = makeValidBoard();
        assertTrue(new Solution().isValidSudoku(board));
    }
    
    private char[][] makeEmpty9x9Board() {
        final char defaultValue = '.';
        return make9x9Board(defaultValue);
    }
    
    private char[][] make9x9Board(char defaultValue) {
        final int N = 9;
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = defaultValue;
            }
        }
        return board;
    }
    
    private char[][] makeValidBoard(){
        int[][] tmp = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9},
        };
        char[][] board = new char[tmp.length][tmp.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(tmp[i][j] == 0) {
                    board[i][j] = '.';
                } else {
                    board[i][j] = (char)('0' + tmp[i][j]);
                }
            }
        }
        return board;
    }
}
