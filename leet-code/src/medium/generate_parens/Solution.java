package medium.generate_parens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> set = generateParenthesis(new HashSet<String>(), n * 2, n, n, "");
        return new ArrayList<String>(set);
    }
    
    private Set<String> generateParenthesis(Set<String> uniqueStrings, int total, int left, int right, String stringSoFar) {
        if(right < left) {
            return uniqueStrings;
        } else if(total == 0) {
            uniqueStrings.add(stringSoFar);
        } else {
            generateParenthesis(uniqueStrings, total - 1, left - 1, right, stringSoFar + "(");
            generateParenthesis(uniqueStrings, total - 1, left, right - 1, stringSoFar + ")");
        }
        return uniqueStrings;
    }
    
    public List<String> generateParenthesis2(int n) {
        Set<String> set = generateParenthesis2(new HashSet<String>(), n, 0, "");
        return new ArrayList<String>(set);
    }
    
    private Set<String> generateParenthesis2(Set<String> uniqueStrings, int total, int openParens, String stringSoFar) {
        if(total == 0) {
            while(openParens > 0) {
                stringSoFar = stringSoFar + ")";
                openParens--;
            }
            uniqueStrings.add(stringSoFar);
        } else {
            // open parens on left
            generateParenthesis2(uniqueStrings, total - 1, openParens + 1, "(" + stringSoFar);
            // open parens of right
            generateParenthesis2(uniqueStrings, total - 1, openParens + 1,  stringSoFar + "(");
            // close parens
            if(openParens > 0) {
                generateParenthesis2(uniqueStrings, total, openParens -1 ,  stringSoFar + ")");
            }
        }
        return uniqueStrings;
    }
}