package week4;

import edu.princeton.cs.algs4.Queue;

/*
 * Corner cases.  You may assume that the constructor receives an N-by-N array containing the N2
 * integers between 0 and N2 − 1, where 0 represents the blank square.

 Performance requirements.  Your implementation should support all Board methods in time proportional to N2
 (or better) in the worst case.
 */
public class Board {
    private static final int EMPTY = 0;
    
    private int[][] tiles;
    private int N;

    // construct a board from an N-by-N array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks) {
        // todo: test board is not null, square, not repeated pieces,
        // 0<pieces<n2
        this.N = blocks.length;
        this.tiles = new int[blocks.length][blocks.length];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.tiles[i][j] = blocks[i][j];
            }
        }
    }

    // board dimension N
    public int dimension() {
        return tiles.length;
    }

    // number of blocks out of place
    public int hamming() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(tiles[i][j] != 0 && tiles[i][j] != i * N + j + 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += manhattanValue(i, j);
            }
        }
        return count;
    }

    // is this board the goal board?
    // 1 2 3
    // 4 5 6
    // 7 8 0
    public boolean isGoal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == N - 1 && j == N - 1) {
                    if(tiles[i][j] != EMPTY) {
                        return false;
                    }
                } else {
                    if(tiles[i][j] != i * N + j + 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        Board twin = new Board(this.tiles);
        // swap the first two adjacent tiles that are non-empty
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if(tiles[i][j] != EMPTY && tiles[i][j + 1] != EMPTY) {
                    swapTiles(twin.tiles, i, j, i, j + 1);
                    return twin;
                }
            }
        }
        return twin;
    }

    // does this board equal y?
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        } else if (this == that) {
            return true;
        } else {
            if (this.getClass() != that.getClass()) {
                return false;
            }
            Board other = (Board) that;
            if (this.N != other.N) {
                return false;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(this.tiles[i][j] != other.tiles[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> neighbors = new Queue<Board>();
        int[] emptyTileCoords = emptyTitleCoords();
        int i = emptyTileCoords[0];
        int j = emptyTileCoords[1];
        
        Board neighbor = null;
        // move zero up
        if(i > 0) {
            neighbor = new Board(this.tiles);
            //neighbor.moves = this.moves + 1;
            swapTiles(neighbor.tiles, i, j, i - 1, j);
            neighbors.enqueue(neighbor);
        }
        // move zero right
        if(j < N - 1) {
            neighbor = new Board(this.tiles);
            //neighbor.moves = this.moves + 1;
            swapTiles(neighbor.tiles, i, j, i, j + 1);
            neighbors.enqueue(neighbor);
        }
        // move zero down
        if(i < N - 1) {
            neighbor = new Board(this.tiles);
            //neighbor.moves = this.moves + 1;
            swapTiles(neighbor.tiles, i, j, i + 1, j);
            neighbors.enqueue(neighbor);
        }
        // move zero left
        if(j > 0) {
            neighbor = new Board(this.tiles);
            //neighbor.moves = this.moves + 1;
            swapTiles(neighbor.tiles, i, j, i, j - 1);
            neighbors.enqueue(neighbor);
        }
        return neighbors;
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    private int manhattanValue(int i, int j) {
        int v = tiles[i][j];
        int expectedI, expectedJ;
        
        if(v == 0) {
            return 0;
        } else {
            expectedI = (v - 1) / N;
            expectedJ = (v - 1) % N;
        }
        int deltaI = Math.abs(expectedI - i);
        int deltaJ = Math.abs(expectedJ - j);
        
        return deltaI + deltaJ;
    }
    
    // returns the coords of the empty tile [x,y]
    private int[] emptyTitleCoords() {
        int[] coords = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(tiles[i][j] == EMPTY) {
                    coords[0] = i;
                    coords[1] = j;
                    return coords;
                }
            }
        }
        return coords;
    }
    
    private void swapTiles(int[][] tiles, int i, int j, int k, int l) {
        int aux = tiles[i][j];
        tiles[i][j] = tiles[k][l];
        tiles[k][l] = aux;
    }

}
