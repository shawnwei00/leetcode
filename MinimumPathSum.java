/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 *
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    grid[0][j] += grid[0][j-1];
                } else if (j == 0) {
                    grid[i][0] += grid[i-1][0];
                } else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        
        return grid[row-1][col-1];
    }
}