package zig_zag_conversion;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        String[] rows = new String[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = "";
        }
        int n = numRows - 1;
        for (int i = 0; i < s.length(); i++) {
            rows[(n - Math.abs(n - (i % (2 * n)))) % (2 * n)] += s.charAt(i);
        }
        String result = "";
        for (int i = 0; i < rows.length; i++) {
            result += rows[i];
        }
        return result;
    }
}