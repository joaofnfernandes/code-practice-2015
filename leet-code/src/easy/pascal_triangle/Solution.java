package easy.pascal_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int rowNumber = 0; rowNumber < numRows; rowNumber++) {
            List<Integer> row = new ArrayList<>();
            int previous = -1;
            for (int j = 0; j < rowNumber + 1; j++) {
                if(j == 0) {
                    previous = 1;
                } else {
                    previous = (previous * (rowNumber + 1 - j)) / j;
                }
                row.add(previous);
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
}