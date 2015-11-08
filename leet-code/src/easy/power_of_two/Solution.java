package easy.power_of_two;

public class Solution {
    // A number is a power of two if has only one bit on
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        int bitsOn = 0;
        for (int i = 0; i < 31; i++) {
            if((n & 0x1) == 1) {
                bitsOn++;
            }
            if(bitsOn > 1) {
                return false;
            }
            n = n>>1;
        }
        return bitsOn == 1;
    }
}