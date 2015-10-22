package isomorphic_strings;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        
        HashMap<Character, Character> StoT = new HashMap<>();
        HashMap<Character, Character> TtoS = new HashMap<>();
        
        for (int i = 0; i < c1.length; i++) {
            if(StoT.containsKey(c1[i])) {
                if(StoT.get(c1[i]) != c2[i]) {
                    return false;
                }
                
            } else {
                if(TtoS.containsKey(c2[i])) {
                    return false;
                }
                StoT.put(c1[i], c2[i]);
                TtoS.put(c2[i], c1[i]);
            }
        }
        return true;
    }
}
