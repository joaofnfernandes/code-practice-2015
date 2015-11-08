package easy.reverse_int;

public class Solution {
    public int reverse(int x) { 
        long result = 0;
        while(x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) result;
        }
    }
    
    
    // We don't need the mask. We can just multiply by 10 each time we add a new digit
    public int reverse2(int x) {
        long result = 0, digit = 0, mask = 1;
        boolean negative = x < 0 ? true : false;
        while(x / mask < -9 || x / mask > 9) {
            mask *=10;
        }
        while(x != 0) {
            digit = Math.abs(x % 10) * mask;
            result += digit; 
            mask /= 10;
            x /= 10;
        }
        if(result > Integer.MAX_VALUE) {
            return 0;
        } else {
            result *= negative ? -1 : 1;
            return (int) result;
        }
    }
}