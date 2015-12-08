package medium.combination_sum;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestSumCombination {

    @Test
    public void testK0N0() {
        final int K = 0;
        final int N = 0;
        List<List<Integer>> result = new Solution().combinationSum3(K, N);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testK3N7() {
        final int K = 3;
        final int N = 7;
        List<List<Integer>> result = new Solution().combinationSum3(K, N);
        List<List<Integer>> expected = new ArrayList<>();
        Integer[][] combinations = {{1,2,4}};
        for (Integer[] combination : combinations) {
            expected.add(new ArrayList<Integer>(Arrays.asList(combination)));
        }
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }
    
    @Test
    public void testK3N9() {
        final int K = 3;
        final int N = 9;
        List<List<Integer>> result = new Solution().combinationSum3(K, N);
        List<List<Integer>> expected = new ArrayList<>();
        Integer[][] combinations = {{1,2,6}, {1,3,5}, {2,3,4}};
        for (Integer[] combination : combinations) {
            expected.add(new ArrayList<Integer>(Arrays.asList(combination)));
        }
        assertTrue(expected.containsAll(result));
        assertTrue(result.containsAll(expected));
    }
}
