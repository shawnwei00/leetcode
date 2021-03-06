/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * 
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 */


public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 0;
        
        int step = 0;
        int right = 0;
        int nextRight = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nextRight >= nums.length - 1) return step + 1;
            if (i <= right) {
                nextRight = Math.max(nextRight, nums[i] + i);
            } else if (right == nextRight ) {
                return 0;
            } else {
                right = nextRight;
                nextRight = Math.max(nextRight, nums[i] + i);
                step++;
            }
        }
        
        return step + 1;
    }
}