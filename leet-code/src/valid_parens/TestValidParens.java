package valid_parens;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestValidParens {

    @Test
    public void testInvalidParens() {
        String[] inputs = { "(", ")", "((", "(]", "{[}", "(((])))", "()(", "())", "([]" };
        Solution sol = new Solution();
        for (String s : inputs) {
            assertFalse(String.format("%s is not valid", s), sol.isValid(s));
        }
    }
    
    @Test
    public void testValidParens() {
        String[] inputs = { "()", "(){}[]", "([{}])", "(((())))", "(()(())((())))", "[({(())}[()])]" };
        Solution sol = new Solution();
        for (String s : inputs) {
            assertTrue(String.format("%s is valid", s), sol.isValid(s));
        }
    }

}
