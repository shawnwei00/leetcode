/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
 * containing all ones and return its area.
 *
 */

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int[] left = new int[col];
        int[] right = new int[col];
        
        for (int i = 0; i < col; i++) {
            right[i] = col;
        }
        
        int maxArea = 0;
        
        for (int i = 0; i < row; i++) {
            int curLeft = 0;
            int curRight = col;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            
            for (int j = col-1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = col;
                    curRight = j;
                }
            }
            
            for (int j = 0; j < col; j++) {
                maxArea = Math.max(maxArea, height[j] * (right[j] - left[j]));
            }
        }
        
        return maxArea;
    }
}