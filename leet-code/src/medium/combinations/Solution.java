package medium.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> combinations;
    
    public List<List<Integer>> combine(int n, int k) {
        combinations = new ArrayList<List<Integer>>();
        combine(new ArrayList<Integer>(), 0, n, k);
        return combinations;
    }
    
    private void combine(ArrayList<Integer> combination, int i, int n, int k) {
        if(i >= n || combination.size() >= k) {
            return;
        }
        i++;
        ArrayList<Integer> copy; 
        // explore using i in combination
        copy = new ArrayList<>(combination);
        copy.add(i);
        if(copy.size() == k) {
            combinations.add(copy);
        } else {
            combine(copy, i, n, k);
        }
        // explore not using i in combination
        copy = new ArrayList<>(combination);
        combine(copy, i, n, k);
    }
}