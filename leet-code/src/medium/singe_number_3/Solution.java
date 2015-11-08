package medium.singe_number_3;

/*Finds two unique numbers on an array of duplicates
 * If we xor all array numbers, the duplicate numbers turn into 0.
 * All the bits that are still on, belong to the two unique numbers.
 * Since we cannot extract the two numbers from their xor, we use a bit
 * to create two groups of numbers.
 * Numbers that have that bit on, are xored into a group,
 * Numbers with that bit off, are xored into another group
 * At the end, duplicate numbers are xored to 0, leaving one unique
 * number in one group, and another unique number in another group
 * */
public class Solution {
    public int[] singleNumber(int[] nums) {
        // num & mask = 0 go into one group, otherwise in other
        int mask = findMask(nums);
        int group1 = 0, group2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & mask) == 0) {
                group1 = group1 ^ nums[i];
            } else {
                group2 = group2 ^ nums[i];
            }
        }
        return new int[] {group1, group2};
    }
    
    // returns a mask that allows distinguishing between the two unique numbers
    private int findMask(int[] nums) {
        int xor = 0;
        // Xor over duplicate numbers returns zero.
        // The only bits that are on, are from the two unique numbers
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        
        // Find the first bit on the xor mask that is on
        int mask = 1;
        while((xor & mask) == 0) {
            mask <<= 1;
        }
        return mask;
    }
}