package easy.reverse_bits;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestReverseBits {

    @Test
    public void testRevertBits() {
        int[] input =    {1, 8, 128, Integer.MIN_VALUE, 268435456, 16777216 };
        int[] expected = {Integer.MIN_VALUE, 268435456, 16777216,1, 8,128};
        Solution sol = new Solution();
        for (int i = 0; i < input.length; i++) {
            assertEquals(String.format("Error reverting %d", input[i]),
                    expected[i], sol.reverseBits(input[i]));
        }
    }
    
}
