/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum 
 * length of S is 1000, and there exists one unique longest palindromic substring.
 */

public class longestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 0) return s;
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = getPalindrome(s, i, i, result);
            result = getPalindrome(s, i, i+1, result);
        }
        
        return result;
    }
    
    public String getPalindrome(String s, int left, int right, String tempResult) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        String palindrome = s.substring(left+1, right);
        return palindrome.length() > tempResult.length() ? palindrome : tempResult;
    }
}