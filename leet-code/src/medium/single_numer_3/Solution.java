package medium.single_numer_3;
/*
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */
public class Solution {
    // Solution with an auxiliary int[32]
    public int singleNumber(int[] nums) {
        // a "bit array" to store the count of each bit of 32-bit ints
        int[] bitArray = new int[32];
        for (int n : nums) {
            int mask = 1;
            for (int i = 31; i >= 0; i--) {
                // if the bit is on, count it. We use != instead of > to handle negative numbers
                if((n & mask) != 0) {
                    bitArray[i] = (bitArray[i] + 1) % 3;
                }
                mask <<= 1;
            }
        }
        // transform the bit array into an integer
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if(bitArray[i] > 0) {
                result = result | (1 << (31 - i));
            }
        }
        return result;
    }
}
