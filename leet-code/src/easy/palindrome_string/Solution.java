package easy.palindrome_string;

public class Solution {
    // iterative solution
    public boolean isPalindrome(String s) {
        if(s.length() <= 1) {
            return true;
        }
        char[] c = s.toLowerCase().toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if (!Character.isLetterOrDigit(c[i])) {
                i++;
            } else if(!Character.isLetterOrDigit(c[j])) {
                j--;
            } else if (c[i] != c[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    
    // recursive solution
    public boolean isPalindrome2(String s) {
        return isPalindrome2(s.toLowerCase().toCharArray(), 0, s.length() - 1);
    }
    
    private boolean isPalindrome2(char[] chars, int i, int j) {
        if(j - i < 1) {
            return true;
        } else if (!Character.isLetterOrDigit(chars[i])) {
            return isPalindrome2(chars, i + 1, j);
        } else if(!Character.isLetterOrDigit(chars[j])) {
            return isPalindrome2(chars, i, j - 1);
        } else if (chars[i] != chars[j]) {
            return false;
        }
        return isPalindrome2(chars, i + 1, j - 1);
    }
}