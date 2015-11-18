package medium.generate_parens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> set = generateParenthesis(new HashSet<String>(), n, "");
        return new ArrayList<String>(set);
    }
    
    public Set<String> generateParenthesis(Set<String> set, int n, String stringSoFar) {
        if(n < 1) {
            return set;
        } else if(n == 1) {
            set.add("()" + stringSoFar);
            set.add(stringSoFar + "()");
            set.add("(" + stringSoFar + ")");
        } else {
            generateParenthesis(set, n - 1, "()" + stringSoFar);
            generateParenthesis(set, n - 1, stringSoFar + "()");
            generateParenthesis(set, n - 1, "(" + stringSoFar + ")");
        }
        return set;
    }
}