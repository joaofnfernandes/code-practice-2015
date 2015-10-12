package nim_game;

import java.util.HashMap;

public class Solution {
    
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    private HashMap<Integer, Boolean> memTable = new HashMap<>();
    
    // recursive memoized version
    public boolean canWinNim2(int n) {
        return canWin(n, true);
    }
    
    private boolean canWin(int n, boolean myTurn) {
        if(memTable.containsKey(n)) {
            return memTable.get(n);
        }
        if(n <= 3) {
            return myTurn;
        } else {
            boolean result;
            if(myTurn) {
                result = canWin(n - 1, false) ||
                        canWin(n - 2, false) ||
                        canWin(n - 3, false);
            } else {
                result = canWin(n - 1, true) &&
                        canWin(n - 2, true) &&
                        canWin(n - 3, true);
            }
            memTable.put(n, result);
            return result;
        }
    }
}
