package easy.excel_col_number;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTitleToNumber {
    
    @Test
    public void TestA(){
        String[] inputs = {"A", "C", "Z"};
        int[] expectedValues = {1, 3, 26};
        
        int result;
        Solution s = new Solution();
        for(int i = 0; i < inputs.length; i++) {
            result = s.titleToNumber(inputs[i]);
            assertEquals(expectedValues[i], result);
        }
    }
    
    @Test
    public void TestAA(){
        String[] inputs = {"AA","AZ", "BA"};
        int[] expectedValues = {27, 52, 53};
        
        int result;
        Solution s = new Solution();
        for(int i = 0; i < inputs.length; i++) {
            result = s.titleToNumber(inputs[i]);
            assertEquals(expectedValues[i], result);
        }
    }

}
