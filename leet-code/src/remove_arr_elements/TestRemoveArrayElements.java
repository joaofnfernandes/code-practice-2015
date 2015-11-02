package remove_arr_elements;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemoveArrayElements {

    @Test
    public void testRemoveArrayElements(){
        int[][] testValues = {{0,0,0,0,0}, {0,1,1,1,1}, {1,1,1,1,0}, {1,1,0,1,1},
                                {0,0,0,1,1}, {1,1,0,0,0},{0,0,1,1,0},
                                {1,0,0,0,0},{0,0,0,0,1},{0,0,1,0,0}};
        int valueToRemove = 0;
        int[] expectedResults = {0,4,4,4,2,2,2,1,1,1};
        Solution sol = new Solution();
        for (int i = 0; i < testValues.length; i++) {
            assertEquals(expectedResults[i], sol.removeElement(testValues[i], valueToRemove));
        }
    }
}
