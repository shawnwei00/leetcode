import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that 
 * no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * 
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 * 	[".Q..",  // Solution 1
 * 	 "...Q",
 * 	 "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (n <= 0) return result;
        
        int[][] nums = new int[n][n];
        
        process(nums, result, 0);
        
        return result;
    }
    
    public void process(int[][] nums, List<List<String>> result, int row) {
        for (int i = 0; i < nums.length; i++) {
            nums[row][i] = 1;
            if (isValid(nums, row, i)) {
                if (row == nums.length - 1) {
                    result.add(toString(nums));
                } else {
                    process(nums, result, row + 1);
                }
            }
            nums[row][i] = 0;
        }
    }
    
    public boolean isValid(int[][] nums, int row, int col) {
        for (int i = 0; i < row; i++) 
            if (nums[i][col] == 1) return false;
            
        for (int i = 0; i < col; i++) 
            if (nums[row][i] == 1) return false;
        
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) 
            if (nums[i][j] == 1) return false;
        
        for (int i = row-1, j = col+1; i >= 0 && j < nums.length; i--, j++) 
            if (nums[i][j] == 1) return false;
        
        return true;
    }
    
    public List<String> toString(int[][] nums) {
        List<String> result = new ArrayList<String>();
        
        for (int i = 0; i < nums.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < nums[0].length; j++) {
                sb.append(nums[i][j] == 1 ? 'Q' : '.') ;
            }
            result.add(sb.toString());
        }
        
        return result;
    }
}