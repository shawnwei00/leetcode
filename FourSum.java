import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *  A solution set is:
 *  
 *  (-1,  0, 0, 1)
 *  (-2, -1, 1, 2)
 *  (-2,  0, 0, 2)
 *
 */

public class FourSum {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
		if (nums == null || nums.length < 4) return result;
		
		Arrays.sort(nums);
		Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
		List<Integer> sumList = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length - 1; i++) {
		    for (int j = i + 1; j < nums.length; j++) {
		        int sum = nums[i] + nums[j];
		        
		        if (map.containsKey(sum)) {
		            map.get(sum).add(new Pair(i, j));
		        } else {
		            List<Pair> list = new ArrayList<Pair>();
		            list.add(new Pair(i, j));
		            map.put(sum, list);
		            sumList.add(sum);
		        }
		    }
		}
		
		sumList.sort(null);
		
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		
		for (Integer sum : sumList) {
		    List<Pair> list1 = map.get(sum);
		    List<Pair> list2 = map.get(target - sum);
		    
		    if (list2 == null) continue;
		    
		    for (Pair p1 : list1) {
		        for (Pair p2 :list2) {
		            if (p1.i2 >= p2.i1) continue;
		            List<Integer> list = Arrays.asList(nums[p1.i1], nums[p1.i2], nums[p2.i1], nums[p2.i2]);
		            if (!set.contains(list)) {
		                result.add(list);
		                set.add(list);
		            }
		        }
		    }
		}
		
		return result;
	}
    
    public static class Pair {
        int i1;
        int i2;
        
        public Pair(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }
    }
}