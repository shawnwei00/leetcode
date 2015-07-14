/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * 
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 *
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        
        int right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > right) return false;
            if (right >= nums.length - 1) return true;
            right = Math.max(right, nums[i] + i);
        }
        
        return true;
    }
}