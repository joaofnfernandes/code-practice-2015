package easy.add_digits;

/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class Solution {
    // iterative solution
    public int addDigits(int num) {
        int result = 0;
        do {
            result = 0;
            while(true) {
                result += num % 10;
                num = num / 10;
                if(num == 0) break;
            }
            num = result;
        } while(num >= 10);
        return num;
    }
    
    // O(1) solution
    public int addDigits2(int num) {
        if(num == 0) {
            return 0;
        }
        int result = num % 9;
        return result == 0 ? 9 : result;
    }
}
