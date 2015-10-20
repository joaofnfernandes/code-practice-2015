package lenght_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;
        char[] chars = s.toCharArray();
        // Advance past right padding
        while(i >= 0 && chars[i] == ' ') 
        {
            i--;
        }
        while(i >= 0 && chars[i] != ' ') 
        {
            i--;
            length++;
        }
        return length;
    }
}