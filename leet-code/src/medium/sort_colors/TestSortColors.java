package medium.sort_colors;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSortColors {

    @Test
    public void testSortColors() {
        int[][] values = {{0,0,0,0}, {1,1,1,1}, {2,2,2,2},
                        {0,0,1,1,2,2},{0,0,0,0,1,2}, {0,1,2,2,2,2}, {0,1,1,1,1,1,2},
                        {2,2,1,1,0,0}, {2,2,2,2,1,0}, {2,2,1,0,0,0,0}, {2,2,1,1,1,1,0},
                        {1,2,1,2,1,2,0}, {0,1,0,2,0,1,0,2}};
        Solution sol = new Solution();
        for (int i = 0; i < values.length; i++) {
            sol.sortColors(values[i]);
            for (int j = 0; j < values[i].length - 1; j++) {
                assertTrue(values[i][j] <= values[i][j + 1]);
            }
        }
    }
}
