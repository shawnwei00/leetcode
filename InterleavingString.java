/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * 
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 */

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s3.length() != (s1.length() + s2.length())) return false;
        
        int l1 = s1.length();
        int l2 = s2.length();
        boolean[][] DP = new boolean[l1+1][l2+1];
        DP[0][0] = true;
        
        for (int i = 1 ; i <= l1; i++) {
            DP[i][0] = DP[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        
        for (int i = 1; i <= l2; i++) {
            DP[0][i] = DP[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                DP[i][j] = (DP[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (DP[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        
        return DP[l1][l2];
        
    }
}