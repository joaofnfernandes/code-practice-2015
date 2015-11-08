package easy.string_occurence;

public class Solution {
    public int strStr(String haystack, String needle) {
        return strStr(haystack, needle, 0);
    }
    
    private int strStr(String haystack, String needle, int i) {
        if(needle.isEmpty()) {
            return i;
        } else if(haystack.length() < needle.length()) {
            return -1;
        } else {
            if(haystack.startsWith(needle)) {
                return i;
            } else {
                return strStr(haystack.substring(1, haystack.length()), needle, i + 1);
            }
        }
    }
}