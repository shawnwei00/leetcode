/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * 
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 * 	[1,   3,  5,  7],
 * 	[10, 11, 16, 20],
 * 	[23, 30, 34, 50]
 * ]
 * 
 * Given target = 3, return true.
 *
 */

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int low = 0;
        int high = row * col - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (getValue(matrix, mid) == target) return true;
            if (getValue(matrix, mid) > target) high = mid - 1;
            else low = mid + 1;
        }
        
        return false;
    }
    
    public int getValue(int[][] matrix, int index) {
        int col = matrix[0].length;
        return matrix[index/col][index%col];
    }
}