/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * 
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 *
 */

public class SearchInPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        
        if (nums[0] >= target) return 0;
        if (nums[nums.length-1] < target) return nums.length;
        
        return searchInsert(nums, 0, nums.length-1, target);
    }
    
    public int searchInsert(int[] nums, int low, int high, int target) {
        if (low > high) return low;
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            return searchInsert(nums, low, mid-1, target);
        } else {
            return searchInsert(nums, mid+1, high, target);
        }
    }
}