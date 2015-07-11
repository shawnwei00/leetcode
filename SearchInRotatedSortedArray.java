/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 *
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return search(nums, 0, nums.length-1, target);
    }
    
    public int search(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        
        int mid = (low + high) / 2;
        if (target == nums[mid]) return mid;
        if (target == nums[low]) return low;
        if (target == nums[high]) return high;
        
        if (nums[low] < nums[mid]) {
            if (target > nums[low] && target < nums[mid]) {
                return search(nums, low+1, mid-1, target);
            } else {
                return search(nums, mid+1, high-1, target);
            }
        } else {
            if (target > nums[mid] && target < nums[high]) {
                return search(nums, mid+1, high-1, target);
            } else {
                return search(nums, low+1, mid-1, target);
            }
        }
    }
}