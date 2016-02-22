package medium.triangle;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestTriangle {

    @Test
    public void testEmptyTriangle() {
        final List<List<Integer>> triangle = triangleToList(new Integer[][] {});
        final int expected = 0;
        int result = new Solution().minimumTotal(triangle);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPathToLeft(){
        final List<List<Integer>> triangle = triangleToList(new Integer[][] {
               {1},
              {1,5},
             {1,5,5},
            {1,5,5,5}
        });
        final int expected = 4;
        int result = new Solution().minimumTotal(triangle);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPathToRight(){
        final List<List<Integer>> triangle = triangleToList(new Integer[][] {
               {1},
              {5,1},
             {5,5,1},
            {5,5,5,1}
        });
        final int expected = 4;
        int result = new Solution().minimumTotal(triangle);
        assertEquals(expected, result);
    }
    
    @Test
    public void testPathInMiddle(){
        final List<List<Integer>> triangle = triangleToList(new Integer[][] {
            {1},
           {5,1},
          {5,1,5},
         {5,1,5,5}
     });
     final int expected = 4;
     int result = new Solution().minimumTotal(triangle);
     assertEquals(expected, result);
    }
    
    @Test
    public void testPathInDifferentDirection(){
        final List<List<Integer>> triangle = triangleToList(new Integer[][] {
            {1},
           {5,1},
          {5,5,5},
         {1,9,9,9}
     });
     final int expected = 12;
     int result = new Solution().minimumTotal(triangle);
     assertEquals(expected, result);
    }
    
    private List<List<Integer>> triangleToList(Integer[][] triangle) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < triangle.length; i++) {
            List<Integer> row = new ArrayList<>(Arrays.asList(triangle[i]));
            list.add(row);
        }
        return list;
    }
}
