/**
 * Implement next permutation, which rearranges numbers into the lexicographically 
 * next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible 
 * order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding 
 * outputs are in the right-hand column.
 * 
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 * 
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        
        int p = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (i == 1 && nums[i] < nums[i-1]) {
                reverse(nums, 0, nums.length-1);
                return;
            }
            if (nums[i] > nums[i-1]) {
                p = i - 1;
                break;
            }
        }
        
        int q = p + 1;
        for (int i = nums.length - 1; i > p; i--) {
            if (nums[p] < nums[i]) {
                q = i;
                break;
            }
        }
        
        swap(nums, p, q);
        
        reverse(nums, p + 1, nums.length - 1);
    }
    
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}