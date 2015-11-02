package atoi;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        char[] chars = str.toCharArray();
        return startState(chars, 0);
    }

    private int startState(char[] chars, int i) {
        if (chars[i] == '+' || chars[i] == '-') {
            return signState(chars, i);
        } else if (chars[i] >= '0' && chars[i] <= '9') {
            return digitState(chars, i, true);
        } else {
            return errorState();
        }
    }


    private int signState(char[] chars, int i) {
        if (i >= chars.length) {
            return errorState();
        } else if (chars[i] != '+' && chars[i] != '-') {
            throw new IllegalStateException("should not be in signState");
        } else {
            boolean isPositive = chars[i] == '+'; 
            i++;
            if (i >= chars.length) {
                return errorState();
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                return digitState(chars, i, isPositive);
            } else {
                return errorState();
            }
        }
    }

    private int digitState(char[] chars, int i, boolean isPositive) {
        if(i >= chars.length) {
            return errorState();
        }
        long result = 0;
        while(i < chars.length && (chars[i] >= '0' && chars[i] <= '9')) {
            result *= 10;
            if(isPositive) {
                result += chars[i] - '0';
            } else {
                result -= chars[i] - '0';
            }
            i++;
            if(result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) result;
    }

    private int errorState() {
        return 0;
    }
}