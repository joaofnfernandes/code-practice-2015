package palindrome_number;

public class Solution {
    // Use a mask to compare the first digit with the last
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if(x < 10) {
            return true;
        }
        int mask = 1;
        while(x / mask >= 10 ) {
            mask *= 10;
        }
        while(x > 1) {
            if(x / mask != x % 10) {
                return false;
            }
            x = (x % mask) / 10; // remove first and last digits
            mask = mask / 100;
        }
        return true;
    }
}
