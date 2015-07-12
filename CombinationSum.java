import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * 
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 <= a2 <= … <= ak).
 * 
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, 
 * 
 * A solution set is:
 *  
 * [7] 
 * [2, 2, 3] 
 *
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (candidates == null || candidates.length == 0) return result;
        
        Arrays.sort(candidates);
        
        return combinationSum(candidates, candidates.length-1, target);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int high, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (high == -1) return result;
        
        for (int i = 0 ; i <= high; i++) {
            if (candidates[i] > target) continue;
            if (candidates[i] == target) {
                result.add(Arrays.asList(candidates[i]));
                continue;
            } else {
                List<List<Integer>> lists = combinationSum(candidates, i, target - candidates[i]);
                for (List<Integer> list : lists) {
                    List<Integer> copyList = new ArrayList<Integer>(list);
                    copyList.add(candidates[i]);
                    result.add(copyList);
                }
            }
        }
        
        return result;
    }
}