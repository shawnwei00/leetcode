/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * 
 * Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 *
 */

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        int[] DP = new int[n+1];
        DP[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                count += DP[j-1] * DP[i-j];
            }
            DP[i] = count;
        }
        
        return DP[n];
    }
}