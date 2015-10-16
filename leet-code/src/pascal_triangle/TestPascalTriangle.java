package pascal_triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;


public class TestPascalTriangle {

    @Test
    public void testPascalTriangle1(){
        int[][] expected = {{1}};
        List<List<Integer>> result = new Solution().generate(1);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void testPascalTriangle3(){
        int[][] expected = {{1},{1,1},{1,2,1}};
        List<List<Integer>> result = new Solution().generate(3);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void testPascalTriangle6(){
        int[][] expected = {{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1},{1,5,10,10,5,1}};
        List<List<Integer>> result = new Solution().generate(6);
        assertTrue(isSameList(expected, result));
    }
    
    private boolean isSameList(int[][] expected, List<List<Integer>> result) {
        if(expected.length != result.size()) {
            return false;
        }
        for (int i = 0; i < expected.length; i++) {
            List<Integer> resultRow = result.get(i);
            if(expected[i].length != resultRow.size()) {
                return false;
            } else {
                for (int j = 0; j < expected[i].length; j++) {
                    if(expected[i][j] != resultRow.get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
