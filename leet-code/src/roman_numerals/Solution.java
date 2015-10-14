package roman_numerals;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('-', 0);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        char previous = '-';

        for (char c : s.toCharArray()) {
            Integer currentValue = map.get(c);
            Integer previousValue = map.get(previous);
            
            if(currentValue <= previousValue) {
                total += currentValue;
            } else {
                total = total - (2 * previousValue) + currentValue;
            }
            previous = c;
        }
        return total;
    }
}
