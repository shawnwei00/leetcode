import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * 
 * [1,1,2] have the following unique permutations:
 * 
 * [1,1,2], [1,2,1], and [2,1,1].
 *
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length == 0) return result;
        
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        
        List<List<Integer>> lists = permuteUnique(Arrays.copyOf(nums, nums.length - 1));
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        
        for (List<Integer> list : lists) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(i, nums[nums.length - 1]);
                if (!set.contains(newList)) {
                    set.add(newList);
                    result.add(newList);
                }
            }
        }
        
        return result;
    }
}