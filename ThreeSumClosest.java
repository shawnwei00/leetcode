import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest 
 * to a given number, target. Return the sum of the three integers. 
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) return target;
        
        Arrays.sort(nums);
        
        int result = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length-2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
                
                if (sum > target) {
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    return target;
                }
            }
        }
        
        return result;
    }
}