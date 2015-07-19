import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * 
 * Note:
 * 
 * Elements in a subset must be in non-descending order.
 * 
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * 
 * If nums = [1,2,2], a solution is:
 * 
 * [
 * 	[2],
 * 	[1],
 * 	[1,2,2],
 * 	[2,2],
 * 	[1,2],
 * 	[]
 * ]
 *
 */

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        return subsetsWithDup(nums, nums.length - 1);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (index == -1) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        int curNum = nums[index];
        
        List<List<Integer>> lists = subsetsWithDup(nums, index-1);
        result.addAll(lists);
        
        int duplicateCount = getDuplicateCount(nums, index);
        
        for (List<Integer> list: lists) {
            if (isValid(list, duplicateCount, curNum)) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(curNum);
                result.add(newList);
            }
        }
        
        return result;
    }
    
    public int getDuplicateCount(int[] nums, int index) {
        int duplicateCount = 0;
        for (int i = index-1; i >= 0; i--) {
            if (nums[i] == nums[index]) duplicateCount++;
            else return duplicateCount;
        }
        return duplicateCount;
    }
    
    public boolean isValid(List<Integer> list, int duplicateCount, int curNum) {
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) == curNum) duplicateCount--;
            else break;
        }
        return duplicateCount == 0;
    }
}