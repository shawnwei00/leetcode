import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * 
 * [1,2,3] have the following permutations:
 * 
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        return permute(nums, nums.length - 1);
    }
    
    public List<List<Integer>> permute(int[] nums, int high) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (high == 0) {
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        
        List<List<Integer>> lists = permute(nums, high - 1);
        for (List<Integer> list : lists) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> copyList = new ArrayList<Integer>(list);
                copyList.add(i, nums[high]);
                result.add(copyList);
            }
        }
        
        return result;
    }
}