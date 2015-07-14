/**
 * Find the contiguous sub array within an array (containing at least one number) which has 
 * the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * 
 * the contiguous sub array [4,-1,2,1] has the largest sum = 6.
 *
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] DP = new int[nums.length];
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                DP[i] = nums[i];
                max = nums[i];
            } else {
                DP[i] = Math.max(nums[i], nums[i] + DP[i-1]);
                max = Math.max(max, DP[i]);
            }
        }
        
        return max;
    }
}