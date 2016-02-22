package medium.h_index;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    // Optimized for input that is sorted in ascending order
    public int hIndex2(int[] citations) {
        if(citations == null || citations.length < 1) { return 0; }
        int N = citations.length;
        for (int i = N - 1; i >= 0; i--) {
            if(citations[i] < (N - i)) { return N - i - 1; }
        }
        return N;
    }
    
    
    // Generic solution
    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1) { return 0; }
        Integer[] values = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            values[i] = new Integer(citations[i]);
        }
        Arrays.sort(values, Collections.reverseOrder());
        for (int i = 0; i < values.length; i++) {
            if(values[i] < i + 1) { return i; }
        }
        return citations.length;
    }
}