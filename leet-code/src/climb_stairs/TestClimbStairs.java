package climb_stairs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClimbStairs {

    @Test
    public void testN() {
        int[] inputs =          {1, 2, 3, 4};
        int[] expectedResults = {1, 2, 3, 5};
        Solution sol = new Solution();
        
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(expectedResults[i], sol.climbStairs(inputs[i]));
            assertEquals(expectedResults[i], sol.climbStairs2(inputs[i]));
        }
    }
}
