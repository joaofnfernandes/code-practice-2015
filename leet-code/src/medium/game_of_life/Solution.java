package medium.game_of_life;

/* computes the next state of a Conway's game of life
 *  each cell stores two states using an int
 *  next state | curr state
 *          0  |  0 -> dead, and will remain that way
 *          0  |  1 -> alive, but will die
 *          1  |  0 -> dead, but will be born
 *          1  |  1 -> alive, and will remain that way
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        // based on initial state, change the cell to store the next|curr states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m - 1, n - 1);
                if(liveNeighbors >= 2 && liveNeighbors <= 3) {
                    if(board[i][j] == 1) {
                        board[i][j] = 3; // 1|1 state
                    } else if(board[i][j] == 0 && liveNeighbors == 3) {
                        board[i][j] = 2; // 1|0 state
                    }
                }
            }
        }
        
        // each cell now stores the next|curr state. We just have to right shift cell state
        // to get the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1; 
            }
        }
    }
    
    private int countLiveNeighbors(int[][] board, int i, int j, int m, int n) {
        int minI = Math.max(i - 1, 0);
        int maxI = Math.min(i + 1, m);
        int minJ = Math.max(j - 1, 0);
        int maxJ = Math.min(j + 1, n);
        int alive = 0;
        for (int k = minI; k <= maxI; k++) {
            for (int l = minJ; l <= maxJ ; l++) {
                if((board[k][l] & 1) == 1) {
                    alive++;
                }
            }
        }
        if((board[i][j] & 1) == 1) {
            alive--;
        }
        return alive;
    }
}