/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * 
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 *
 */

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] DP = new int[s.length() + 1];
        DP[0] = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int num1 = Integer.parseInt(s.substring(i, i+1));
            if (num1 >=1 && num1 <= 9) {
                DP[i+1] += DP[i];
            } else {
                DP[i+1] = 0;
            }
            
            if (i-1 >= 0) {
                int num2 = Integer.parseInt(s.substring(i-1, i+1));
                if (num2 >= 10 && num2 <= 26) {
                    DP[i+1] += DP[i-1];
                }
            }
        }
        
        return DP[s.length()];
    }
}