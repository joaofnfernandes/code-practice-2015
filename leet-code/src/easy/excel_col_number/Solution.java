package easy.excel_col_number;

public class Solution {
    
    private static final int ZERO = 'A' - 1;
    
    public int titleToNumber(String s) {
        int result = 0, unitValue = 0;
        s = s.toUpperCase();
        for(int i = 0; i < s.length(); i++) {
           unitValue = s.charAt(i) - ZERO;
           result = 26 * result + unitValue;
       }
        return result;
    }
}
