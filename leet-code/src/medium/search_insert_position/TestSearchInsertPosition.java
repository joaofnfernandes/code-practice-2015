package medium.search_insert_position;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestSearchInsertPosition {

    @Test
    public void testTargetExistsInPos0() {
        int[] input = { 0, 1, 4, 5, 9 };
        int target = 0;
        int expected = 0;
        assertEquals(expected, new Solution().searchInsert(input, target));
    }

    @Test
    public void testTargetExistsInPosN() {
        int[] input = { 0, 1, 4, 5, 9 };
        int target = 9;
        int expected = 4;
        assertEquals(expected, new Solution().searchInsert(input, target));
    }

    @Test
    public void tesTtargetExistsInMiddle() {
        int[] input = { 0, 1, 4, 5, 9 };
        int target = 1;
        int expected = 1;
        assertEquals(expected, new Solution().searchInsert(input, target));
    }

    @Test
    public void testTargetShouldBeInPos0() {
        int[] input = { 1, 3, 5, 10 };
        int target = 0;
        int expected = 0;
        assertEquals(expected, new Solution().searchInsert(input, target));
    }

    @Test
    public void testTargetShouldBeInPosN() {
        int[] input = { 1, 3, 5, 10 };
        int target = 20;
        int expected = 4;
        assertEquals(expected, new Solution().searchInsert(input, target));
    }

    @Test
    public void testTargetShouldbeInMiddle() {
        int[] input = { 1, 3, 5, 10 };
        int target = 9;
        int expected = 3;
        assertEquals(expected, new Solution().searchInsert(input, target));
    }

}
