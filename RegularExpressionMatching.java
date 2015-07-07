/**
 * '.' Matches any single character
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") -> true
 * isMatch("aa", ".*") -> true
 * isMatch("ab", ".*") -> true
 * isMatch("aab", "c*a*b") -> true
 *
 */

public class RegularExpressionMatching {
	
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        
        int m = s.length();
        int n = p.length();
        boolean[][] DP = new boolean[m+1][n+1];
        
        DP[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            DP[0][i] = i > 1 && p.charAt(i - 1) == '*' && DP[0][i-2];
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    DP[i][j] = DP[i][j-2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && DP[i-1][j];
                } else {
                    DP[i][j] = DP[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j - 1) == '.');
                }
            }
        }
        
        return DP[m][n];
    }
    
}