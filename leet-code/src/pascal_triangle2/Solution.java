package pascal_triangle2;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        long previous = -1;
        for (int j = 0; j <= result.length / 2; j++) {
            if (j == 0) {
                previous = 1;
            } else {
                previous = (previous * (rowIndex + 1 - j)) / j;
            }
            result[j] = (int)previous;
        }
        for(int j = result.length - 1; j > result.length / 2; j--) {
            result[j] = result[result.length - 1 - j];
        }
        return Arrays.asList(result);
    }
}