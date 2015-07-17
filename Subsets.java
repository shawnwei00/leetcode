import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order.
 * 
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * 
 * If nums = [1,2,3], a solution is:
 * 
 * [
 * 	[3],
 * 	[1],
 * 	[2],
 * 	[1,2,3],
 * 	[1,3],
 * 	[2,3],
 * 	[1,2],
 * 	[]
 * ]
 *
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        int max = nums[nums.length-1];
        List<List<Integer>> lists = subsets(Arrays.copyOfRange(nums, 0, nums.length-1));
        
        for (List<Integer> list : lists) {
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(max);
            result.add(newList);
        }
        
        result.addAll(lists);
        
        return result;
    }
}