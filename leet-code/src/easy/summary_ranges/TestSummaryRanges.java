package easy.summary_ranges;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSummaryRanges {
    
    @Test
    public void testSummaryRanges() {
        int[][] input = {{}, {1}, {1,2}, {1,2,3,4,5},{1,9},{1,3,5,7},
                            {1,2,3,9}, {1,7,8,9},{1,2,4,6,8,9}};
        String[][] expected = {{}, {"1"}, {"1->2"}, {"1->5"},{"1", "9"},{"1","3","5","7"},
                                {"1->3","9"}, {"1","7->9"}, {"1->2","4","6","8->9"}};
        Solution sol = new Solution();
        List<String> listResult;
        String[] result;
        for (int i = 0; i < input.length; i++) {
            listResult = sol.summaryRanges(input[i]);
            result = new String[listResult.size()];
            result = listResult.toArray(result);
            assertArrayEquals(String.format("%s failed", Arrays.toString(input[i])),result, expected[i]);
        }
    }

}
