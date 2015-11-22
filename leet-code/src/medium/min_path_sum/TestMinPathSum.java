package medium.min_path_sum;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMinPathSum {

    @Test
    public void testEmptyGrid() {
        int[][] grid = new int[0][0];
        int expected = 0;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    
    @Test
    public void testGrid2x2Path1(){
        int[][] grid = {{0,1},{5,1}};
        int expected = 2;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    
    @Test
    public void testGrid2x2Path2(){
        int[][] grid = {{0,5},{1,1}};
        int expected = 2;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    
    @Test
    public void testGrid4x4StraightPath() {
        int[][] grid = {{0,1,1,1},{5,5,5,1},{5,5,5,1},{5,5,5,1}};
        int expected = 6;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    
    @Test
    public void testGrid4x4ZigZagPath() {
        int[][] grid = {{0,1,5,5},{5,1,1,5},{5,5,1,1},{5,5,5,1}};
        int expected = 6;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    
    @Test
    public void testGrid4x4MultiplePaths() {
        int[][] grid = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int expected = 6;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    @Test
    public void testGrid3x2StraightPath() {
        int[][] grid = {{0,1},{5,1},{5,1}};
        int expected = 3;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    
    @Test
    public void testGrid3x2ZigZagPath() {
        int[][] grid = {{0,5},{1,1},{5,1}};
        int expected = 3;
        assertEquals(expected, new Solution().minPathSum(grid));
    }
    
    @Test
    public void testGrid3x2MultiplePaths() {
        int[][] grid = {{0,1},{1,1},{1,1}};
        int expected = 3;
        assertEquals(expected, new Solution().minPathSum(grid));
    }

}
