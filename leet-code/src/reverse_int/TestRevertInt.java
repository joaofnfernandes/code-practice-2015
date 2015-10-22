package reverse_int;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRevertInt {

    @Test
    public void testRevert(){
        int[] input = {0, 1, 200, 1001, 1234, 123456789, -1, -200, -1001, -1234};
        int[] expected = {0,1, 002, 1001, 4321, 987654321, -1, -002, -1001, -4321};
        Solution sol = new Solution();
        for (int i = 0; i < input.length; i++) {
            assertEquals(expected[i], sol.reverse(input[i]));
        }
    }
    
    @Test
    public void testOverflow(){
        int[] input = {1234567899, -1234567899};
        int[] expected = {0, 0};
        Solution sol = new Solution();
        for (int i = 0; i < input.length; i++) {
            assertEquals(expected[i], sol.reverse(input[i]));
        }
    }
}
