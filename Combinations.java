import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * 
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 * 	[2,4],
 * 	[3,4],
 * 	[2,3],
 * 	[1,2],
 * 	[1,3],
 * 	[1,4],
 * ]
 *
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       
       if (n < k || k <= 0) return result;
       
       if (n == k) {
           List<Integer> list = new ArrayList<Integer>();
           for (int i = 1; i <= n; i++) {
               list.add(i);
           }
           result.add(list);
           return result;
       }
       
       if (k == 1) {
           for (int i = 1; i <= n; i++) {
               List<Integer> list = new ArrayList<Integer>();
               list.add(i);
               result.add(list);
           }
           return result;
       }
       
       result.addAll(combine(n-1, k));
       List<List<Integer>> lists = combine(n-1, k-1);
       
       for (List<Integer> list : lists) {
           List<Integer> copyList = new ArrayList<Integer>(list);
           copyList.add(n);
           result.add(copyList);
       }
       
       return result;
    }
    
}