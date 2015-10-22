package longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;
        int j = strs[i].length();
        while(i < strs.length - 1) {
            if(j == 0) {
                return "";
            } else if(strs[i + 1].length() < j) {
                j--;
            } else if(!strs[i].substring(0, j).equals(strs[i+1].substring(0, j))) {
                j--;
            } else {
                i++;
            }
        }
        return strs[i].substring(0, j);
        
    }
}