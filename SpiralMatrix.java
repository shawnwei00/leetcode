import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix 
 * in spiral order.
 * 
 * For example,
 * 
 * Given the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 4, 5, 6 ],
 * 	[ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int upper = 0;
        int bottom = m - 1;
        int left = 0; 
        int right = n - 1;
        
        while (upper <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[upper][i]);
            }
            upper++;
            
            for (int i = upper; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            if (upper <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            bottom--;
            
            if (left <= right) {
                for (int i = bottom; i >= upper; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        
        return result;
    }
}