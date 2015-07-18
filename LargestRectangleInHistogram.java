import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of 
 * largest rectangle in the histogram.
 * 
 * For example,
 * 
 * Given height = [2,1,5,6,2,3],
 * return 10.
 *
 */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int maxArea = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] < height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    int right = stack.pop();
                    maxArea = Math.max(maxArea, height[right] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                }
                stack.push(i);
            }
        }
        
        if (!stack.isEmpty()) {
            if (stack.peek() != (height.length - 1)) {
                stack.pop();
                stack.push(height.length - 1);
            }
            int right = stack.peek();
            while (!stack.isEmpty()) {
                int h = height[stack.pop()];
                maxArea = Math.max(maxArea, h * (stack.isEmpty() ? (right + 1) : (right - stack.peek())));
            }
        }
        
        return maxArea;
    }
}