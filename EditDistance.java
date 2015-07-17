/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();
        if (word1.equals(word2)) return 0;
        
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        int[][] DP = new int[row][col];
        
        for (int i = 1; i < row; i++) {
            DP[i][0] = i;
        }
        
        for (int i = 1; i < col; i++) {
            DP[0][i] = i;
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    DP[i][j] = DP[i-1][j-1];
                } else {
                    DP[i][j] = Math.min(DP[i-1][j-1], Math.min(DP[i-1][j], DP[i][j-1])) + 1;
                }
            }
        }
        
        return DP[row-1][col-1];
    }
}