package week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

// Percolation uses 0-based indexing internally, but exposes 1-based indexing to clients
public class Percolation {

    private static final boolean OPEN = true;

    private final int N;
    private final int TOP;
    private final int BOTTOM;

    // tells if a cell is open or close
    private boolean[] cellState;
    // allows quickly checking if percolates
    private WeightedQuickUnionUF ufWithGhostCells;
    // check which cells are full without backwash bug
    private WeightedQuickUnionUF ufNoGhostCells;


    // Create N-by-N grid, with all sites blocked
    public Percolation(int N) {
        // We always add two extra "ghost" cells. N-2: ghost top cell, N-1: ghost bottom cell
        this.N = N;
        cellState = new boolean[N * N + 2];
        ufWithGhostCells = new WeightedQuickUnionUF(N * N + 2);
        ufNoGhostCells = new WeightedQuickUnionUF(N * N + 2);
        TOP = N * N;
        BOTTOM = N * N + 1;

        openGhostCells();
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j){
        open0Based(i - 1, j - 1);
    }

    private void open0Based(int i, int j) {
        if(i < 0 || i >= N || j < 0 || j >= N ) {
            throw new IndexOutOfBoundsException();
        }
        cellState[getCellId(i, j)] = OPEN;
        tryConnectAdjacentCells(i, j);
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j){
        return isOpen0Based(i - 1, j - 1);
    }
    
    private boolean isOpen0Based(int i, int j) {
        return cellState[getCellId(i, j)];
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
        return isFull0Based(i - 1, j - 1);
    }
    
    private boolean isFull0Based(int i, int j) {
        // Is open and connected to top
        return cellState[getCellId(i, j)] && 
                ufNoGhostCells.connected(TOP, getCellId(i, j));
    }

    // does the system percolate?
    public boolean percolates(){
        return percolates0Based();
    }
    
    private boolean percolates0Based(){
        return ufWithGhostCells.connected(TOP, BOTTOM);
    }

    private int getCellId(int i, int j) {
        if(i < 0 || i >= N || j < 0 || j >= N ) {
            throw new IndexOutOfBoundsException();
        }
        return i * N + j;
    }

    private void openGhostCells() {
        cellState[TOP] = OPEN;
        cellState[BOTTOM] = OPEN;
    }

    private void tryConnectAdjacentCells(int i, int j) {
        if(i < 0 || i >= N || j < 0 || j >= N ) {
            throw new IndexOutOfBoundsException();
        }

        int cellId = getCellId(i, j);
        // If an adjacent cell is open, connect to it
        if(j - 1 >= 0 && cellState[getCellId(i, j - 1)]) {
            ufWithGhostCells.union(cellId, getCellId(i, j - 1));
            ufNoGhostCells.union(cellId, getCellId(i, j - 1));
        }
        if(j + 1 < N && cellState[getCellId(i, j + 1)]) {
            ufWithGhostCells.union(cellId, getCellId(i, j + 1));
            ufNoGhostCells.union(cellId, getCellId(i, j + 1));
        }
        if(i - 1 >= 0 && cellState[getCellId(i - 1, j)]) {
            ufWithGhostCells.union(cellId, getCellId(i - 1, j));
            ufNoGhostCells.union(cellId, getCellId(i -1, j));
        }
        if(i + 1 < N && cellState[getCellId(i + 1, j)]) {
            ufWithGhostCells.union(cellId, getCellId(i + 1, j));
            ufNoGhostCells.union(cellId, getCellId(i + 1, j));
        }
        
        // if cell in top row, connect with TOP ghost cell
        if(i == 0) {
            ufWithGhostCells.union(TOP, cellId);
            ufNoGhostCells.union(TOP, cellId);
        }
        
        // if cell in bottom row, connect with BOTTOM ghost cell
        if(i == N - 1) {
            ufWithGhostCells.union(BOTTOM, cellId);
        }
    }
}
