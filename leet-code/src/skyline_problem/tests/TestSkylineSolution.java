package skyline_problem.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import skyline_problem.Solution;

import static org.junit.Assert.*;

public class TestSkylineSolution {

    private static final String TEST_PATH = System.getenv("TEST_RESOURCES");

    @Test
    public void testSingleBuilding() {
        final int[][] buildings = { { 0, 10, 10 } };
        final int[][] expected = { { 0, 10 }, { 10, 0 } };
        assertTrue(arraysAreEqual(expected, new Solution().getSkyline(buildings)));

    }

    @Test
    public void testLeftInterceptBottom() {
        final String file = TEST_PATH + "left-intercept-1.txt";
        final int[][] expected = { { 0, 5 }, { 1, 10 }, { 10, 0 } };
        int[][] buildings = readBuildingsFromFile(file);
        assertTrue(arraysAreEqual(expected, new Solution().getSkyline(buildings)));
    }

    @Test
    public void testLeftInterceptTop() {
        final String file = TEST_PATH + "left-intercept-2.txt";
        final int[][] expected = { { 0, 10 }, { 5, 5 }, { 10, 0 } };
        int[][] buildings = readBuildingsFromFile(file);
        assertTrue(arraysAreEqual(expected, new Solution().getSkyline(buildings)));
    }

    @Test
    public void testRightInterceptBottom() {
        final String file = TEST_PATH + "right-intercept-1.txt";
        final int[][] expected = { { 0, 10 }, { 5, 5 }, { 10, 0 } };
        int[][] buildings = readBuildingsFromFile(file);
        assertTrue(arraysAreEqual(expected, new Solution().getSkyline(buildings)));
    }

    @Test
    public void testRightInterceptTop() {
        final String file = TEST_PATH + "right-intercept-2.txt";
        final int[][] expected = { { 0, 5 }, { 1, 10 }, { 10, 0 } };
        int[][] buildings = readBuildingsFromFile(file);
        assertTrue(arraysAreEqual(expected, new Solution().getSkyline(buildings)));
    }

    @Test
    public void testSmallerBuildingsBehind() {
        final String file = TEST_PATH + "smaller-buildings-behind.txt";
        final int[][] expected = { { 0, 10 }, { 10, 0 } };
        int[][] buildings = readBuildingsFromFile(file);
        assertTrue(arraysAreEqual(expected, new Solution().getSkyline(buildings)));
    }

    @Test
    public void testTallerBuildingBehind() {
        final String file = TEST_PATH + "taller-buildings-behind.txt";
        final int[][] expected = { { 0, 5 }, { 1, 10 }, { 5, 5 }, { 10, 0 } };
        int[][] buildings = readBuildingsFromFile(file);
        assertTrue(arraysAreEqual(expected, new Solution().getSkyline(buildings)));
    }

    private int[][] readBuildingsFromFile(String filename) {
        try {
            Scanner s = new Scanner(new File(filename));
            int N = s.nextInt();
            int x1, x2, y;
            int[][] buildings = new int[N][3];
            for (int i = 0; i < N; i++) {
                x1 = s.nextInt();
                x2 = s.nextInt();
                y = s.nextInt();
                buildings[i] = new int[] { x1, x2, y };
            }
            return buildings;
        } catch (FileNotFoundException e) {
            fail(String.format("Test file not found:\n%s", filename));
            return null;
        }
    }

    private boolean arraysAreEqual(int[][] expected, List<int[]> result) {
        if (expected.length != result.size()) {
            return false;
        }
        int[] a, b;
        for (int i = 0; i < expected.length; i++) {
            a = expected[i];
            b = result.get(i);
            if (a[0] != b[0] || a[1] != b[1]) {
                return false;
            }
        }
        return true;

    }
}
