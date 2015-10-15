package happy_numbers;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(true) {
            n = sumOfSquares(n);
            if(n == 0 || n == 1) {
                return true;
            }
            if(!set.add(n)) {
                return false;
            }
        }
    }

    private int sumOfSquares(int n) {
        int total = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            total += digit * digit;
            n = n / 10;
        }
        return total;
    }
}
