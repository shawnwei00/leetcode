/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example, 
 * 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int hIndex = 0;
        int heighest = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > heighest) {
                heighest = height[i];
                hIndex = i;
            }
        }
        
        int result = 0;
        int left = height[0];
        int right = height[height.length - 1];
        
        for (int i = 1; i < hIndex; i++) {
            if (height[i] > left) {
                left = height[i];
            } else {
                result += (left - height[i]);
            }
        }
        
        for (int i = height.length - 2; i > hIndex; i--) {
            if (height[i] > right) {
                right = height[i];
            } else {
                result += (right - height[i]);
            }
        }
        
        return result;
    }
}