package medium.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> permutationSoFar = new LinkedList<>();
        List<Integer> notUsedSoFar = new LinkedList<>();
        for (int n : nums) {
            notUsedSoFar.add(n);
        }
        permute(permutations, permutationSoFar, notUsedSoFar);
        return permutations;
    }
    
    private void permute(List<List<Integer>> permutations, List<Integer> permutationSoFar, List<Integer> notUsedSoFar) {
        if(notUsedSoFar.isEmpty() && !permutationSoFar.isEmpty()) {
            permutations.add(permutationSoFar);
            return;
        }
        for (int i = 0; i < notUsedSoFar.size(); i++) {
            List<Integer> notUsedSoFarCopy = new LinkedList<>(notUsedSoFar);
            List<Integer> permutationSoFarCopy = new LinkedList<>(permutationSoFar);
            permutationSoFarCopy.add(notUsedSoFar.get(i));
            notUsedSoFarCopy.remove(i);
            permute(permutations, permutationSoFarCopy, notUsedSoFarCopy);
        }
    }
}