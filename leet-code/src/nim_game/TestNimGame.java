package nim_game;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestNimGame {
    
    // Tests that you win if there are 1,2, or 3 blocks
    @Test
    public void test1235() {
        assertTrue(new Solution().canWinNim(1));
        assertTrue(new Solution().canWinNim(2));
        assertTrue(new Solution().canWinNim(3));
        assertTrue(new Solution().canWinNim(5));
        assertTrue(new Solution().canWinNim(41));
    }
    
    // Tests that you lose with 0 or 4 blocks
    @Test
    public void test4() {
        assertFalse(new Solution().canWinNim(4));
    }

}
