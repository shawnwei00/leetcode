import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * 
 * Given binary tree {3,9,20,#,#,15,7},
 * 
    3
   / \
  9  20
    /  \
   15   7

 * return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
 *
 */

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        process(list, result);
        return result;
    }
    
    public void process(List<TreeNode> nodeList, List<List<Integer>> result) {
        if (nodeList.isEmpty()) return;
        
        List<TreeNode> newNodeList = new ArrayList<TreeNode>();
        List<Integer> intList = new ArrayList<Integer>();
        for (TreeNode node : nodeList) {
            if (node.left != null) newNodeList.add(node.left);
            if (node.right != null) newNodeList.add(node.right);
            intList.add(node.val);
        }
        
        result.add(0, intList);
        process(newNodeList, result);
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}