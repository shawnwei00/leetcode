/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * 
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 *
 */

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        if (s.length() < t.length()) return 0;
        
        int l1 = s.length() + 1;
        int l2 = t.length() + 1;
        int[][] DP = new int[l1][l2];
        DP[0][0] = 1;
        
        for (int i = 1; i < l1; i++) {
            DP[i][0] = 1;
        }
        
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (i < j) {
                    DP[i][j] = 0;
                } else if (s.charAt(i-1) == t.charAt(j-1)) {
                    DP[i][j] = DP[i-1][j-1] + DP[i-1][j];
                } else {
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        
        return DP[l1-1][l2-1];
    }
}