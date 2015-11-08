package easy.remove_duplicates;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;

public class TestRemoveDuplicates {

    @Test
    public void testNoDuplicates1Element(){
        int[] input = {1};
        Solution sol = new Solution();
        int result = sol.removeDuplicates(input);
        assertTrue(validateNonDuplicatesOrder(input, result));
        assertTrue(validateDuplicatesNumber(input, result));
    }
    
    @Test
    public void testNoDuplicates2Elements(){
        int[] input = {1,2};
        Solution sol = new Solution();
        int result = sol.removeDuplicates(input);
        assertTrue(validateNonDuplicatesOrder(input, result));
        assertTrue(validateDuplicatesNumber(input, result));
    }
    
    @Test
    public void testNoDuplicatesNElements(){
        int[] input = {1,2,3,4,5,6,7};
        Solution sol = new Solution();
        int result = sol.removeDuplicates(input);
        assertTrue(validateNonDuplicatesOrder(input, result));
        assertTrue(validateDuplicatesNumber(input, result));
    }
    
    @Test
    public void testDuplicatesToLeft(){
        int[] input = {1,1,1,1,2,3};
        Solution sol = new Solution();
        int result = sol.removeDuplicates(input);
        assertTrue(validateNonDuplicatesOrder(input, result));
        assertTrue(validateDuplicatesNumber(input, result));
    }
    
    @Test
    public void testDuplicatesToRight(){
        int[] input = {1,2,3,4,5,6,6};
        Solution sol = new Solution();
        int result = sol.removeDuplicates(input);
        assertTrue(validateNonDuplicatesOrder(input, result));
        assertTrue(validateDuplicatesNumber(input, result));
    }
    
    @Test
    public void testDuplicatesMiddle(){
        int[] input = {1,2,2,2,2,3};
        Solution sol = new Solution();
        int result = sol.removeDuplicates(input);
        assertTrue(validateNonDuplicatesOrder(input, result));
        assertTrue(validateDuplicatesNumber(input, result));
    }
    
    @Test
    public void testDuplicatesInterleaved(){
        int[] input = {1,2,2,3,3,3,3,4,5,5,6};
        Solution sol = new Solution();
        int result = sol.removeDuplicates(input);
        assertTrue(validateNonDuplicatesOrder(input, result));
        assertTrue(validateDuplicatesNumber(input, result));
    }
    
    private boolean validateNonDuplicatesOrder(int[] nums, int max) {
        for (int i = 0; i < max - 2; i++) {
            if(nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean validateDuplicatesNumber(int[] nums, int nonDuplicates) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer value : nums) {
            set.add(value);
        }
        return set.size() == nonDuplicates;
    }
}
