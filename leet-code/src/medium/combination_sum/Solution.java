package medium.combination_sum;

import java.util.ArrayList;
import java.util.List;

// finds all the combinations of [1-9] with K elements that sum to N
public class Solution {
    private List<List<Integer>> combinations;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinations = new ArrayList<>();
        if(k > 0 && n > 0) {
            combinationSum3(new ArrayList<Integer>(), 0, 1, k, n);
        }
        return combinations;
    }
    
    private void combinationSum3(List<Integer> combination, int currentSum, int currentValue,
                                        int totalElements, int targetValue) {
        if(combination.size() > totalElements) {return;}
        else if(currentSum > targetValue){return;}
        else if(currentValue > 9) {return;}
        else {
            List<Integer> combinationCopy;
            // explore not using number
            combinationCopy = new ArrayList<Integer>(combination);
            if(combinationCopy.size() == totalElements && currentSum == targetValue) {
                combinations.add(combinationCopy);
            } else {
                combinationSum3(combinationCopy, currentSum, currentValue + 1, totalElements, targetValue);
            }

            // explore using number
            combinationCopy = new ArrayList<Integer>(combination);
            combinationCopy.add(currentValue);
            currentSum += currentValue;
            currentValue++;
            if(combinationCopy.size() == totalElements && currentSum == targetValue) {
                combinations.add(combinationCopy);
            } else {
                combinationSum3(combinationCopy, currentSum, currentValue, totalElements, targetValue);
            }
        }
    }
}