/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int[] DP = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) DP[i] = 1;
            if (i == 1) DP[i] = 2;
            if (i > 1) DP[i] = DP[i-1] + DP[i-2];
        }
        
        return DP[n-1];
    }
}