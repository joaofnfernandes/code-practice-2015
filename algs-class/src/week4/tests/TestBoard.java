package week4.tests;

import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.princeton.cs.algs4.In;

import static org.junit.Assert.*;

import week4.Board;


public class TestBoard {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private static final String PATH = System.getenv("TEST_RESOURCES") + "board-tests/";
    
    // test board doesn't mutate constructor input
    @Test
    public void TestDoesntMutateInput() {
        int[][] originalTiles = makeSolutionTiles(3);
        int[][] tiles = copyArray(originalTiles);
        
        // Create board and do some operations
        Board b = new Board(tiles);
        b.isGoal();
        //b.neighbors();
        //b.twin();
         
        assertTrue(arraysEqual(originalTiles, tiles));
    }
    
    // test board dimensions
    @Test
    public void TestBoardDimensions() {
        int[] dims = {2, 3, 4, 5};
        Board[] boards = new Board[4];
        for (int i = 0; i < dims.length; i++) {
            boards[i] = new Board(makeSolutionTiles(dims[i]));
        }
        for (int i = 0; i < dims.length; i++) {
            assertEquals(dims[i], boards[i].dimension());
        }
    }
    
    // test equals
    @Test
    public void TestBoardEquals() {
        testEqualsSameBoard();
        testNotEqualsDiffBoards00();
        testNotEqualsDiffBoardsCenter();
    }

    // test isGoal
    @Test
    public void TestIsGoal() {
        testIsGoal();
        testIsNotGoal();
        testTwinIsNotGoal();
    }
    
    @Test
    public void TestHammingDistance() {
        final String[] testFiles = {"hamming-0.txt", "hamming-1.txt", "hamming-7.txt"};
        final int[] expectedResults = {0, 1, 7};
        Board b;
        
        for (int i = 0; i < testFiles.length; i++) {
            b = readBoardFromFile(PATH + testFiles[i]);
            assertEquals(expectedResults[i], b.hamming());
        }
    }
    
    @Test
    public void TestManhattanDistance(){
        final String[] testFiles = {"manhattan-0.txt", "manhattan-2.txt", "manhattan-4.txt"};
        final int[] expectedResults = {0, 2, 4};
        Board b;
        
        for (int i = 0; i < testFiles.length; i++) {
            b = readBoardFromFile(PATH + testFiles[i]);
            assertEquals(expectedResults[i], b.manhattan());
        }
    }
    
    @Test
    public void TestNeighbors() {
        final String[] testFiles = {"neighbors-2-1.txt", "neighbors-2-2.txt", "neighbors-2-3.txt",
                                    "neighbors-3-1.txt", "neighbors-3-2.txt",
                                    "neighbors-4.txt"};
        final int[] expectedResults = {2, 2, 2, 3, 3, 4};
        Board b;
        
        for (int i = 0; i < testFiles.length; i++) {
            b = readBoardFromFile(PATH + testFiles[i]);
            assertEquals(expectedResults[i], getNeighborsCount(b));
        }
    }
    
    private void testIsGoal() {
        Board b3 = new Board(makeSolutionTiles(3));
        Board b5 = new Board(makeSolutionTiles(5));
        Board b7 = new Board(makeSolutionTiles(7));
        
        assertTrue(b3.isGoal());
        assertTrue(b5.isGoal());
        assertTrue(b7.isGoal());
    }
    
    private void testIsNotGoal() {
        int[][] tiles = makeSolutionTiles(3);
        swapTiles(tiles, 0, 0, 2, 2);
        assertFalse(new Board(tiles).isGoal());
        swapTiles(tiles, 0, 0, 2, 2);
        swapTiles(tiles, 0, 0, 1, 1);
        assertFalse(new Board(tiles).isGoal());
        
    }
    
    private void testTwinIsNotGoal() {
        Board b = new Board(makeSolutionTiles(3));
        Board t = b.twin();
        
        assertTrue(b.isGoal());
        assertFalse(t.isGoal());
    }

    private void testEqualsSameBoard() {
        Board b1 = new Board(makeSolutionTiles(3));
        Board b2 = b1;
        Board b3 = new Board(makeSolutionTiles(3));
        
        assertTrue(b1.equals(b2));
        assertTrue(b1.equals(b3));
    }
    
    private void testNotEqualsDiffBoards00() {
        Board b1 = new Board(makeSolutionTiles(3));
        int[][] tilesB2 = makeSolutionTiles(3);
        swapTiles(tilesB2, 0, 0, 2, 2);
        Board b2 = new Board(tilesB2);
        
        assertFalse(b1.equals(b2));
        assertFalse(b2.equals(b1));
    }
    
    private void testNotEqualsDiffBoardsCenter() {
        Board b1 = new Board(makeSolutionTiles(3));
        int[][] tilesB2 = makeSolutionTiles(3);
        swapTiles(tilesB2, 0, 0, 1, 1);
        Board b2 = new Board(tilesB2);
        
        assertFalse(b1.equals(b2));
        assertFalse(b2.equals(b1));
    }
    
    private int[][] makeSolutionTiles(int N) {
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = i * N + j + 1; 
            }
        }
        tiles[N - 1][N - 1] = 0;
        return tiles;
    }
    
    private boolean arraysEqual(int[][] arr1, int[][] arr2) {
        if(arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
            return false;
        }
        if(arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int[][] copyArray(int[][] arr) {
        int[][] copy = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    private void swapTiles(int[][] tiles, int i, int j, int k, int l) {
        int aux = tiles[i][j];
        tiles[i][j] = tiles[k][l];
        tiles[k][l] = aux;
    }
    
    private Board readBoardFromFile(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        return new Board(tiles);
    }
    
    private int getNeighborsCount(Board board) {
        int count = 0;
        Iterator<Board> neighbors = board.neighbors().iterator();
        while(neighbors.hasNext()) {
            count++;
            neighbors.next();
        }
        return count;
    }
}

