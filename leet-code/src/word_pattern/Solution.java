package word_pattern;

import java.util.HashMap;

// Could use two hashmaps, to avoid using map.containsValue()
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        char patternElement;
        for (int i = 0; i < pattern.length(); i++) {
            patternElement = pattern.charAt(i);
            if(map.containsKey(patternElement)) {
                if(words[i].compareTo(map.get(patternElement)) != 0) {
                    return false;
                }
            } else {
                if(map.containsValue(words[i])) {
                    return false;
                }
                map.put(patternElement, words[i]);
            }
        }
        return true;
    }
}