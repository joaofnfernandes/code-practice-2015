package add_binary_strings;

public class Solution {
    private static final char ONE = '1';

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean b1 = false, b2 = false, carry = false;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                b1 = false;
                b2 = isOne(b.charAt(j));
            } else if (j < 0) {
                b1 = isOne(a.charAt(i));
                b2 = false;
            } else {
                b1 = isOne(a.charAt(i));
                b2 = isOne(b.charAt(j));
            }
            addBitToString(builder, b1 ^ b2 ^ carry);
            carry = (b1 & b2) | (b1 ^ b2) & carry; 
            i--;
            j--;
        }
        if(carry) {
            addBitToString(builder, true);
        }
        return builder.reverse().toString();
    }

    private void addBitToString(StringBuilder builder, boolean bit) {
        builder.append(bit ? "1" : "0");
    }

    private boolean isOne(char c) {
        return c == ONE;
    }
}
