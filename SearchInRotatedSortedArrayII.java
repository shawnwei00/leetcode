/**
 * Follow up for "Search in Rotated Sorted Array":
 * 
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 *
 */

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return search(nums, 0, nums.length-1, target);
    }
    
    public boolean search(int[] nums, int low, int high, int target) {
        if (low > high) return false;
        int mid = (low + high) / 2;
        if (nums[mid] == target) return true;
        
        if (nums[low] > nums[mid]) {
            if (target > nums[mid] && target <= nums[high]) {
                return search(nums, mid+1, high, target);
            } else {
                return search(nums, low, mid-1, target);
            }
        } else if (nums[low] < nums[mid]) {
            if (target >= nums[low] && target < nums[mid]) {
                return search(nums, low, mid-1, target);
            } else {
                return search(nums, mid+1, high, target);
            }
        } else {
            return search(nums, low+1, mid-1, target) || search(nums, mid+1, high, target);
        }
    }
}