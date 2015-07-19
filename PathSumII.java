import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * 
 * Given the below binary tree and sum = 22,
 * 
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        
 * return
 * 
 * [
 * 	[5,4,11,2],
 * 	[5,8,4,5]
 * ]
 * 
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        pathSum(root, sum, lists, list);
        return lists;
    }
    
    public void pathSum(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list) {
        if (root == null) return;
        if (isLeaf(root) && root.val != sum) return;
        
        if (isLeaf(root) && root.val == sum) {
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(root.val);
            lists.add(newList);
            return;
        }
        
        list.add(root.val);
        pathSum(root.left, sum-root.val, lists, new ArrayList<Integer>(list));
        pathSum(root.right, sum-root.val, lists, new ArrayList<Integer>(list));
    }
    
    public boolean isLeaf(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
}