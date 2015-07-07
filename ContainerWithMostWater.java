/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at 
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of 
 * line i is at (i, ai) and (i, 0). 
 * 
 * Find two lines, which together with x-axis forms a container, such that the container 
 * contains the most water.
 * 
 * Note: You may not slant the container.
 *
 */
 
public class ContainerWithMostWater {
	
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length-1;
        int left = height[leftIndex];
        int right = height[rightIndex];
        
        int result = Math.min(left, right) * (rightIndex - leftIndex);
        
        while (leftIndex < rightIndex) {
            if (left >= right) {
                rightIndex--;
                right = height[rightIndex];
            } else {
                leftIndex++;
                left = height[leftIndex];
            }
            result = Math.max(result, Math.min(left, right) * (rightIndex - leftIndex));
        }
        
        return result;
    }
    
}