import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
 * For example:
 * 
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
   
 * return its level order traversal as:
 * 
[
  [3],
  [9,20],
  [15,7]
]
 *
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        
        process(list, result);
        
        return result;
    }
    
    public void process(List<TreeNode> list, List<List<Integer>> result) {
        if (list.isEmpty()) {
            return;
        }
        
        List<TreeNode> newList = new ArrayList<TreeNode>();
        List<Integer> intList = new ArrayList<Integer>();
        
        for (TreeNode node : list) {
            intList.add(node.val);
            if (node.left != null) newList.add(node.left);
            if (node.right != null) newList.add(node.right);
        }
        
        result.add(intList);
        
        process(newList, result);
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}