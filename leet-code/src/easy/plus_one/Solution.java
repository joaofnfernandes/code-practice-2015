package easy.plus_one;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        boolean carry = true;
        int digit;
        for (int i = digits.length - 1; i >= 0; i--) {
            digit = digits[i];
            if (carry) {
                digit++;
            }
            if (digit / 10 > 0) {
                carry = true;
                digit = digit % 10;
            } else {
                carry = false;
            }
            digits[i] = digit;
        }
        if(carry) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            digits = newDigits;
        }
        return digits;
    }
}
