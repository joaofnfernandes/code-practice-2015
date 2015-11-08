package easy.climb_stairs;

public class Solution {
    // iterative solution
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        } else {
            int n1 = 1;
            int n2 = 2;
            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = n1 + n2;
                n1 = n2;
                n2 = result;
            }
            return result;
        }
    }
    
    // Recursive solution
    public int climbStairs2(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2); 
    }
}
