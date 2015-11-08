package easy.nearby_duplicates;

import java.util.HashMap;

// We don't need the tree set. We can store the map, the position of the last occurrence
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // maps values with a tree with their indexes
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if(i - index <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}