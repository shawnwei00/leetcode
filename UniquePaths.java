import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid
 * 
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid
 * 
 * How many possible unique paths are there?
 *
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        
        int[] result = new int[m];
        Arrays.fill(result, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                result[j] += result[j - 1];
            }
        }
        
        return result[m - 1];
    }
}