package pascal_triangle2;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPacalTriangleRow {

    @Test
    public void test1() {
        int input = 1;
        Integer[] expected = { 1,1 };
        List<Integer> list = new Solution().getRow(input);
        Integer[] result = new Integer[list.size()];
        list.toArray(result);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void test5() {
        int input = 5;
        Integer[] expected = { 1, 5, 10, 10, 5, 1 };
        List<Integer> list = new Solution().getRow(input);
        Integer[] result = new Integer[list.size()];
        list.toArray(result);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void test30() {
        int input = 30;
        Integer[] expected = {1,30,435,4060,27405,142506,593775,2035800,5852925,14307150,30045015,
                                54627300,86493225,119759850,145422675,155117520,145422675,119759850,
                                86493225,54627300,30045015,14307150,5852925,2035800,593775,
                                142506,27405,4060,435,30,1};
        List<Integer> list = new Solution().getRow(input);
        Integer[] result = new Integer[list.size()];
        list.toArray(result);
        
        assertArrayEquals(expected, result);
    }
}
