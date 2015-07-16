/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * 
 * Given n = 3,
 * 
 * You should return the following matrix:
 * 
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 8, 9, 4 ],
 * 	[ 7, 6, 5 ]
 * ]
 *
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        
        int[][] result = new int[n][n];
        
        int num = 1;
        int left = 0; int right = n - 1;
        int upper = 0; int bottom = n - 1;
        
        while (left <= right && upper <= bottom) {
            for (int i = left; i <= right; i++) {
                result[upper][i] = num++;
            }
            upper++;
            
            for (int i = upper; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;
            
            if (upper <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;
                }
            }
            bottom--;
            
            if (left <= right) {
                for (int i = bottom; i >= upper; i--) {
                    result[i][left] = num++;
                }
            }
            left++;
        }
        
        return result;
    }
}