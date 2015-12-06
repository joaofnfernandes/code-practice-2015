package medium.combinations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestCombinations {
    
    @Test
    public void TestN2K0() {
        final int N = 2;
        final int K = 0;
        List<List<Integer>> result = new Solution().combine(N, K);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void TestN0K2() {
        final int N = 0;
        final int K = 2;
        List<List<Integer>> result = new Solution().combine(N, K);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void TestN4K2() {
        final int N = 4;
        final int K = 2;
        List<List<Integer>> result = new Solution().combine(N, K);
        
        Integer[][] tmp = {{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};
        List<List<Integer>> expected = new ArrayList<>();
        for (Integer[] element : tmp) {
            expected.add(Arrays.asList(element));
        }
        
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }
}
