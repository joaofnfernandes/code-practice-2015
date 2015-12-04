package medium.game_of_life;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameOfLife {

    // tests that a board with only dead cells, stays that way
    @Test
    public void TestEmptyBoard() {
        int[][] board = makeEmptyBoard();
        int[][] expected = makeEmptyBoard();
        new Solution().gameOfLife(board);
        assertTrue(isSameBoard(expected, board));
    }
    
    // tests that cells without neighbors, die off
    @Test
    public void TestBoardWithSingleCells(){
        int[][] board = {
                {1,0,0,1},
                {0,0,0,0},
                {0,0,0,0},
                {1,0,0,1}
        };
        int[][] expected = makeEmptyBoard();
        new Solution().gameOfLife(board);
        assertTrue(isSameBoard(expected, board));
    }
    
    // tests that vertical lines, transform into squares
    @Test
    public void TestBoardWithVerticalLine() {
        int[][] board = {
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0}
        };
        int[][] expected = {
                {0,0,0,0},
                {1,1,0,0},
                {1,1,0,0},
                {0,0,0,0}
        };
        new Solution().gameOfLife(board);
        assertTrue(isSameBoard(expected, board));
    }
    
    // tests horizontal lines, transform into squares
    @Test
    public void TestBoardWithHorizontalLine() {
        int[][] board = {
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        int[][] expected = {
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        new Solution().gameOfLife(board);
        assertTrue(isSameBoard(expected, board));
    }
    
    // tests that edge cells in an diagonal line, die off
    @Test
    public void TestBoardWithDiagonalLine() {
        int[][] board = {
                {0,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        int[][] expected = makeEmptyBoard();
        new Solution().gameOfLife(board);
        assertTrue(isSameBoard(expected, board));
    }
    
    // + shapes transform into squares with empty middle
    @Test
    public void testBoardWithCross() {
        int[][] board = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {0,0,0,0}
        };
        int[][] expected = {
                {1,1,1,0},
                {1,0,1,0},
                {1,1,1,0},
                {0,0,0,0}
        };
        new Solution().gameOfLife(board);
        assertTrue(isSameBoard(expected, board));
    }
    
    // Triangles turn into rectangles with a spike
    @Test
    public void testBoardWithTriangle(){
        int[][] board = {
            {0,1,0,0},
            {1,1,1,0},
            {0,0,0,0},
            {0,0,0,0}
        };
        int[][] expected = {
                {1,1,1,0},
                {1,1,1,0},
                {0,1,0,0},
                {0,0,0,0}
        };
        new Solution().gameOfLife(board);
        assertTrue(isSameBoard(expected, board));
    }
    
    private int[][] makeEmptyBoard() {
        final int N = 4;
        return makeEmptyBoard(N);
    }
    
    private int[][] makeEmptyBoard(int N) {
        return new int [N][N];
    }
    
    private boolean isSameBoard(int[][] board1, int[][] board2) {
        if (board1.length != board2.length) {
            return false;
        } else {
            for (int i = 0; i < board1.length; i++) {
                if (board1[i].length != board2[i].length) {
                    return false;
                } else {
                    for (int j = 0; j < board1[i].length; j++) {
                        if(board1[i][j] != board2[i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
