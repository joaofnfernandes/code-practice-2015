package week4.tests;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import edu.princeton.cs.algs4.In;

import week4.Board;
import week4.Solver;

public class TestSolver {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private static final String PATH = System.getenv("TEST_RESOURCES")
            + "solver-tests/";

    @Test
    public void TestExceptionOnNullConstructor() {
        exception.expect(NullPointerException.class);
        @SuppressWarnings("unused")
        Solver s = new Solver(null);
    }

    @Test
    public void TestNotSolvable() {
        String[] files = { "unsolvable-1.txt", "unsolvable-2.txt",
                "unsolvable-3.txt", "unsolvable-4.txt", "unsolvable-5.txt",
                "unsolvable-6.txt", "unsolvable-7.txt" };
        Solver s;
        for (String file : files) {
            s = new Solver(readBoardFromFile(PATH + file));
            assertFalse(s.isSolvable());
            assertEquals(-1, s.moves());
            assertEquals(null, s.solution());
        }
    }

    @Test
    public void TestSolvable0Moves() {
        String[] files = { "solvable-0-1.txt", "solvable-0-2.txt",
                "solvable-0-3.txt" };
        Solver s;
        Board b;
        for (String file : files) {
            b = readBoardFromFile(PATH + file);
            assertTrue(b.isGoal());
            s = new Solver(b);
            assertTrue(s.isSolvable());
            assertEquals(0, s.moves());
        }
    }

    @Test
    public void TestSolvable1Moves() {
        String[] files = { "solvable-1-1.txt", "solvable-1-2.txt",
                "solvable-1-3.txt", "solvable-1-4.txt" };
        Solver s;
        Board b;
        for (String file : files) {
            b = readBoardFromFile(PATH + file);
            s = new Solver(b);
            assertTrue("Board should be solvable", s.isSolvable());
            int expectedMoves = 1;
            int resultMoves = s.moves();
            assertEquals(String.format("Expected %1d, but was %2d",
                    expectedMoves, resultMoves), expectedMoves, resultMoves);
        }
    }

    @Test
    public void TestSolvableNMoves() {
        String[] files = { "solvable-21.txt", "solvable-22.txt", "solvable-23.txt",
                        "solvable-24.txt", "solvable-25.txt", "solvable-26.txt"};
        int[] expectedMoves = {21, 22, 23, 24, 25, 26};
        
        Solver s;
        Board b;
        
        for (int i = 0; i < files.length/2; i++) {
            b = readBoardFromFile(PATH + files[i]);
            s = new Solver(b);
            assertTrue("Board should be solvable", s.isSolvable());
            int resultMoves = s.moves();
            assertEquals(String.format("Expected %1d, but was %2d",
                    expectedMoves[i], resultMoves), expectedMoves[i], resultMoves);
        }
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
}
