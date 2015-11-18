package medium.generate_parens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> set = generateParenthesis(new HashSet<String>(), n, 0, "");
        return new ArrayList<String>(set);
    }
    
    public Set<String> generateParenthesis(Set<String> uniqueStrings, int total, int openParens, String stringSoFar) {
        if(total == 0) {
            while(openParens > 0) {
                stringSoFar = stringSoFar + ")";
                openParens--;
            }
            uniqueStrings.add(stringSoFar);
        } else {
            // open parens on left
            generateParenthesis(uniqueStrings, total - 1, openParens + 1, "(" + stringSoFar);
            // open parens of right
            generateParenthesis(uniqueStrings, total - 1, openParens + 1,  stringSoFar + "(");
            // close parens
            if(openParens > 0) {
                generateParenthesis(uniqueStrings, total, openParens -1 ,  stringSoFar + ")");
            }
        }
        return uniqueStrings;
    }
}