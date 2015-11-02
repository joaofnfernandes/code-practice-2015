package summary_ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int i = 0, j = 0;
        while(j < nums.length) {
            if(j + 1 < nums.length && nums[j + 1] - nums[i] == j + 1 - i) {
                j++;
            } else {
                if(i == j) {
                    result.add(String.format("%d", nums[i]));
                } else {
                    result.add(String.format("%d->%d", nums[i], nums[j]));
                }
                j++;
                i = j;
            }
        }
        return result;
    }
}