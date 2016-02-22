package medium.subsets;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class TestSubsets {

    @Test
    public void testN0() {
        int[] nums = {};
        List<List<Integer>> result = new Solution().subsets(nums);
        assertEquals(1, result.size());
        assertEquals(0, result.get(0).size());
    }
    
    @Test
    public void testN3Sorted()  {
        int[] nums = {1,2,3};
        List<List<Integer>> resultList = new Solution().subsets(nums);
        Integer[][] result = new Integer[resultList.size()][];
        int i = 0;
        for (List<Integer> list : resultList) {
            Integer[] listValues = new Integer[list.size()];
            result[i++] = list.toArray(listValues);
        }
        Integer[][] expected = {{},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}};
        assertEquals(expected.length, result.length);
        for (int j = 0; j < expected.length; j++) {
            assertArrayEquals(expected[j], result[j]);
        }
        
    }
    
    @Test
    public void testN3Unsorted()  {
        int[] nums = {4,1,0};
        List<List<Integer>> resultList = new Solution().subsets(nums);
        Integer[][] result = new Integer[resultList.size()][];
        int i = 0;
        for (List<Integer> list : resultList) {
            Integer[] listValues = new Integer[list.size()];
            result[i++] = list.toArray(listValues);
        }
        
        Integer[][] expected = {{},{0},{1},{4},{0,1},{0,4},{1,4},{0,1,4}};
        for (int j = 0; j < expected.length; j++) {
            assertArrayEquals(expected[j], result[j]);
        }
    }
}
