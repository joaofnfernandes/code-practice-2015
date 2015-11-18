package medium.generate_parens;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestGenerateParens {

    @Test
    public void test0() {
        int n = 0;
        String[] expected = {};
        List<String> result = new Solution().generateParenthesis(n);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void test1(){
        int n = 1;
        String[] expected = {"()"};
        List<String> result = new Solution().generateParenthesis(n);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void test2(){
        int n = 2;
        String[] expected = {"()()", "(())"};
        List<String> result = new Solution().generateParenthesis(n);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void test3(){
        int n = 3;
        String[] expected = {"((()))", "(()())", "(())()", "()(())", "()()()"};
        List<String> result = new Solution().generateParenthesis(n);
        assertTrue(isSameList(expected, result));
    }
    
    @Test
    public void test4(){
        int n = 4;
        String[] expected = {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())",
                              "(()())()","(())(())","(())()()","()((()))","()(()())","()(())()",
                              "()()(())","()()()()"};
        List<String> result = new Solution().generateParenthesis(n);
        assertTrue(isSameList(expected, result));
    }
    
    private boolean isSameList(String[] expected, List<String> result) {
        List<String> list = Arrays.asList(expected);
        return result.containsAll(list);
    }
}
