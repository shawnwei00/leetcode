/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 */

public class NQueenII {
    
    public int totalNQueens(int n) {
        int[][] nums = new int[n][n];
        
        Count count = new Count();
        process(0, nums, count);
        
        return count.value;
    }
    
    public void process(int row, int[][] nums, Count count) {
        for (int i = 0; i < nums.length; i++) {
            nums[row][i] = 1;
            if (isValid(row, i, nums)) {
                if (row == nums.length - 1) {
                    count.value++;
                } else {
                    process(row + 1, nums, count);
                }
            }
            nums[row][i] = 0;
        }
    }
    
    public boolean isValid(int row, int col, int[][] nums) {
        for (int i = 0; i < row; i++) {
            if (nums[i][col] == 1) return false;
        }
        
        for (int i = 0; i < col; i++) {
            if (nums[row][i] == 1) return false;
        }
        
        for (int i = row-1, j = col-1; i >=0 && j >= 0; i--, j--) {
            if (nums[i][j] == 1) return false;
        }
        
        for (int i = row-1, j = col+1; i >= 0 && j < nums.length; i--, j++) {
            if (nums[i][j] == 1) return false;
        }
        
        return true;
    }
    
    public static class Count {
    	int value;
    	Count() { value = 0; }
    }
    
}