package nearby_duplicates;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNearbyDuplicates {
    
    @Test
    public void testNoDuplicatesPossible(){
        int k = 0;
        int[] values = {0,0,0,0,0,0,0,0,0,0};
        Solution sol = new Solution();
        assertFalse(sol.containsNearbyDuplicate(values, k));
    }
    
    @Test
    public void testDuplicatesTooFar(){
        int k = 1;
        int[] values = {0,1,2,1,0};
        Solution sol = new Solution();
        assertFalse(sol.containsNearbyDuplicate(values, k));
    }
    
    @Test
    public void testDuplicatesInRange(){
        int k = 2;
        int[] values = {0,1,2,1,3,4};
        Solution sol = new Solution();
        assertTrue(sol.containsNearbyDuplicate(values, k));
    }
    
    @Test
    public void testMultipleDuplicates(){
        int k = 1;
        int values[] = {0,0,0,0,0,0,0,0,0};
        Solution sol = new Solution();
        assertTrue(sol.containsNearbyDuplicate(values, k));
    }
    
    

}
