package easy.reverse_bits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            // shift result to left
            result <<= 1;
            // add least significant digit to result
            result = result | (n & 1);
            // shit n to right
            n >>>= 1;
        }
        return result;
    }
}
