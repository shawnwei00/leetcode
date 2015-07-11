/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * 
 * return [3, 4].
 *
 */

public class SearchForARange {

	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		if (nums == null || nums.length == 0) return result;
		if (nums[0] > target || nums[nums.length - 1] < target) return result;

		result[0] = searchStart(nums, 0, nums.length - 1, target);
		result[1] = searchEnd(nums, 0, nums.length - 1, target);

		return result;
	}

	public int searchStart(int[] nums, int low, int high, int target) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (mid == 0 && nums[mid] == target) return 0;
		if (nums[mid] == target && nums[mid - 1] != target) return mid;
		if (nums[mid] >= target) {
			return searchStart(nums, low, mid - 1, target);
		} else {
			return searchStart(nums, mid + 1, high, target);
		}
	}

	public int searchEnd(int[] nums, int low, int high, int target) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (mid == nums.length - 1 && nums[mid] == target) return mid;
		if (nums[mid] == target && nums[mid + 1] != target) return mid;
		if (nums[mid] <= target) {
			return searchEnd(nums, mid + 1, high, target);
		} else {
			return searchEnd(nums, low, mid - 1, target);
		}
	}

}
