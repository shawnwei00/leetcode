/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * 
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * 
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * 
 * isMatch("aa","a") -> false
 * isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false
 * isMatch("aa", "*") -> true
 * isMatch("aa", "a*") -> true
 * isMatch("ab", "?*") -> true
 * isMatch("aab", "c*a*b") -> false
 * 
 */

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        
        int n = s.length();
        int m = p.length();
        
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') count++;
        }
        
        if (count == 0 && m != n) return false;
        if (m - count > n) return false;
        
        boolean[][] DP = new boolean[n+1][m+1];
        DP[0][0] = true;
        
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) == '*' && DP[0][i-1]) DP[0][i] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    DP[i][j] = DP[i-1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    for (int l = i; l >= 0; l--) {
                        if (DP[l][j-1]) {
                            DP[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return DP[n][m];
    }
}