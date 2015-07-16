import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * 
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 *
 */

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> meta = new ArrayList<Integer>();
        int[] factorial = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            meta.add(i);
        }
        
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                factorial[i] = 1;
            } else {
                factorial[i] = factorial[i - 1] * i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        k--;
        
        for(int i = n - 1; i >= 1; i--) {
            int index = k / factorial[i];
            sb.append(meta.get(index));
            meta.remove(index);
            k = k % factorial[i];
        }
        
        sb.append(meta.get(0));
        
        return sb.toString();
    }
}