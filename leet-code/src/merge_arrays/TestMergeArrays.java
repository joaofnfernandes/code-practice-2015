package merge_arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMergeArrays {

    @Test
    public void testLeftIsEmpty(){
        int[] left = new int[2];
        int[] right = new int[]{1,2};
        int[] expected = {1,2};
        new Solution().merge(left, 0, right, 2);
        assertArrayEquals(expected, left);
    }
    
    @Test
    public void testRightIsEmpty(){
        int[] left = new int[] {1,2};
        int[] right = new int[2];
        int[] expected = {1,2};
        new Solution().merge(left, 2, right, 0);
        assertArrayEquals(expected, left);
    }
    
    @Test
    public void leftHasSmallerElements(){
        int[] left = {1,2,3,0,0,0};
        int[] right = {4,5,6};
        int[] expected = {1,2,3,4,5,6};
        new Solution().merge(left, 3, right, 3);
        assertArrayEquals(expected, left);
    }
    
    @Test
    public void rightHasSmallerElements(){
        int[] left = {4,5,6,0,0,0};
        int[] right = {1,2,3};
        int[] expected = {1,2,3,4,5,6};
        new Solution().merge(left, 3, right, 3);
        assertArrayEquals(expected, left);
    }
    
    @Test
    public void leftHasMoreElements(){
        int[] left = {2,3,4,0,0};
        int[] right = {1,5};
        int[] expected = {1,2,3,4,5};
        new Solution().merge(left, 3, right, 2);
        assertArrayEquals(expected, left);
    }
    
    @Test
    public void rightHasMoreElements(){
        int[] left = {1,5,0,0,0};
        int[] right = {2,3,4};
        int[] expected = {1,2,3,4,5};
        new Solution().merge(left, 2, right, 3);
        assertArrayEquals(expected, left);
    }
    
    @Test
    public void leftHasElementsInMiddle() {
        int[] left = {3,0,0,0,0};
        int[] right = {1,2,4,5};
        int[] expected = {1,2,3,4,5};
        new Solution().merge(left, 1, right, 4);
        assertArrayEquals(expected, left);
    }
}
