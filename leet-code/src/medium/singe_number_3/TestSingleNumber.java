package medium.singe_number_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSingleNumber {

    @Test
    public void testUniqueTogether() {
        int[] values = {1,1,2,2,3,3,4,5};
        int[] expected = {4,5};
        assertTrue(areSameValues(expected, new Solution().singleNumber(values)));
    }
    
    @Test
    public void testUniqueOnEnds() {
        int[] values = {4,1,1,2,2,3,3,5};
        int[] expected = {4,5};
        assertTrue(areSameValues(expected, new Solution().singleNumber(values)));
    }
    
    @Test
    public void testSameNumbers() {
        int[] values = {15,15,15,15,15,15,4,5};
        int[] expected = {4,5};
        assertTrue(areSameValues(expected, new Solution().singleNumber(values)));
    }
    
    @Test
    public void testUniqueHaveAlmostSameBits() {
        int[] values = {1,15,1,2,2,3,23,3};
        int[] expected = {15,23};
        assertTrue(areSameValues(expected, new Solution().singleNumber(values)));
    }
    
    @Test
    public void testShuffledNumbers() {
        int[] values = {5,1,15,2,23,2,3,1,5,3,4,4};
        int[] expected = {15,23};
        assertTrue(areSameValues(expected, new Solution().singleNumber(values)));
    }
    
    private boolean areSameValues(int[] p, int[] q) {
        return (p[0] == q[0] && p[1] == q[1]) ||
                (p[0] == q[1] && p[1] == q[0]);
    }
}
