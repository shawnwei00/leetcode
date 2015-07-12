import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C 
 * where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers.
 * 
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 <= a2 <= … <= ak).
 * 
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * 
 * A solution set is: 
 * 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 *
 */

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        return combinationSum2(candidates, candidates.length - 1, target);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int high, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (high == -1) return result;
        
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0 ; i <= high; i++) {
            if (candidates[i] > target) continue;
            if (candidates[i] == target) {
                List<Integer> list = Arrays.asList(candidates[i]);
                if (!set.contains(list)) {
                    result.add(list);
                    set.add(list);
                }
            } else {
                List<List<Integer>> lists = combinationSum2(candidates, i - 1, target - candidates[i]);
                for (List<Integer> list : lists) {
                    List<Integer> copyList = new ArrayList<Integer>(list);
                    copyList.add(candidates[i]);
                    if (!set.contains(copyList)) {
                        result.add(copyList);
                        set.add(copyList);
                    }
                }
            }
        }
        
        return result;
    }
}