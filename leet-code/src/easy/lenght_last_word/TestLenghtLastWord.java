package easy.lenght_last_word;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestLenghtLastWord {

    @Test
    public void testLengthLastWord() {
        String[] inputs = {"helloworld", "hello world", "yellow world", "low world", "  hello  world   ", 
                            "hello w", "   "};
        int[] expectedValues = {10,5,5,5,5,1,0};
        Solution sol = new Solution();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(String.format("%s", inputs[i]),expectedValues[i], sol.lengthOfLastWord(inputs[i]));
        }
    }
}
