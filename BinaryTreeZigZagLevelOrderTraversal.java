import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
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
   
 * return its zigzag level order traversal as:
 * 
[
  [3],
  [20,9],
  [15,7]
]
 *
 */
public class BinaryTreeZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) return result;
        
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        nodeList.add(root);
        
        process(nodeList, result, true);
        
        return result;
    }
    
    public void process(List<TreeNode> nodeList, List<List<Integer>> result, boolean order) {
        if (nodeList.isEmpty()) return;
        
        List<TreeNode> newNodeList = new ArrayList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(TreeNode node : nodeList) {
            if (order) {
                list.add(node.val);
            } else {
                list.add(0, node.val);
            }
            if (node.left != null) newNodeList.add(node.left);
            if (node.right != null) newNodeList.add(node.right);
        }
        
        result.add(list);
        process(newNodeList, result, !order);
    }

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}