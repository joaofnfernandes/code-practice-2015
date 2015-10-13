package excel_col_number;

public class Solution {
    public int titleToNumber(String s) {
        int col = 0, i = 0, unitValue = 0;
       
        while(!s.isEmpty()) {
            unitValue = (s.charAt(s.length() - 1) - 65 + 1);
            col += (int)Math.pow(26, i) * unitValue;
            
            i++;
            s = s.substring(0, s.length() - 1);
        }
        return col;
    }
}
