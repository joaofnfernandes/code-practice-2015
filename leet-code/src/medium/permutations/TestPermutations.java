package medium.permutations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPermutations {

    @Test
    public void testEmptyList() {
        int[] nums = {};
        List<List<Integer>> result = new Solution().permute(nums);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void test2N() {
        int[] nums = {1,2};
        int[][] expectedValues = new int[][]{{1,2}, {2,1}};
        List<List<Integer>> result = new Solution().permute(nums);
        List<List<Integer>> expected = toList(expectedValues);
        assertTrue(isSameList(expected, result));
        
    }
    
    @Test
    public void test3N() {
        int[] nums = {1,2,3};
        int[][] expectedValues = new int[][]{{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
        List<List<Integer>> result = new Solution().permute(nums);
        List<List<Integer>> expected = toList(expectedValues);
        assertTrue(isSameList(expected, result));
    }
    
    
    private List<List<Integer>> toList(int[][] values) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            List<Integer> elements = new ArrayList<>();
            for (int j = 0; j < values[i].length; j++) {
                elements.add(values[i][j]);
            }
            list.add(elements);
        }
        return list;
    }
    
    private boolean isSameList(List<List<Integer>> l1, List<List<Integer>> l2) {
        if(l1.size() != l2.size()) {
            return false;
        }
        return l1.containsAll(l2);
    }
}
