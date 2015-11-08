package easy.valid_parens;

import java.util.HashMap;
import java.util.Stack;

//Use a stack to push and pop parens.
public class Solution {
    HashMap<Character, Character> openParens;
    HashMap<Character, Character> closingParens;
    
    public boolean isValid(String s) {
        init();

        
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char popped;
        for (char c : chars) {
            if(isOpenParens(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                popped = stack.pop();
                if(popped != getOpenParens(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private void init() {
        openParens = new HashMap<>();
        openParens.put('(', ')');
        openParens.put('[', ']');
        openParens.put('{', '}');
        
        
        closingParens = new HashMap<>();
        closingParens.put(')', '(');
        closingParens.put(']', '[');
        closingParens.put('}', '{');
    }
    
    private boolean isOpenParens(char c) {
        return openParens.containsKey(c);
    }
    
    private char getOpenParens(char c) {
        return closingParens.get(c);
    }
}
