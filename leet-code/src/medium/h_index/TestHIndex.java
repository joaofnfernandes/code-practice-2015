package medium.h_index;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHIndex {

    @Test
    public void testNoPubs()  {
        int[] citations = {};
        int expected = 0;
        int result = new Solution().hIndex(citations);
        assertEquals(expected, result);
    }
    
    @Test
    public void test1PubNCitation() {
        int[] citations = {50};
        int expected = 1;
        int result = new Solution().hIndex(citations);
        assertEquals(expected, result);
    }
    
    @Test
    public void testNPubs1Citation() {
        int[] citations = {1,1,1,1,1,1,1,1,1,1};
        int expected = 1;
        int result = new Solution().hIndex(citations);
        assertEquals(expected, result);
    }
    
    @Test
    public void testNPubsNCitations() {
        int[] citations = {20,20,20,20,20};
        int expected = 5;
        int result = new Solution().hIndex(citations);
        assertEquals(expected, result);
    }
    
    @Test
    public void testAscendingCitations() {
        int[] citations = {1,2,3,4,5,6,7};
        int expected = 4;
        int result = new Solution().hIndex(citations);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPubs() {
        int[][] citations = {{0,0,0}, {0,50,2}, {3,0,6,1,5}};
        int expected[] = {0, 2, 3};
        int result;
        for (int i = 0; i < citations.length; i++) {
            result = new Solution().hIndex(citations[i]);
            assertEquals(expected[i], result);
        }
        
    }
}
