import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * 
 * Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 *
 */

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        if (n == 0) {
            result.add(null);
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(1));
            return result;
        }
        
        List<TreeNode> list = generateTrees(n-1);
        
        for (TreeNode node : list) {
            TreeNode newNode = new TreeNode(n);
            newNode.left = copyTree(node);
            result.add(newNode);
        }
        
        for (TreeNode node : list) {
            TreeNode root = node;
            while(node != null) {
                result.add(addNode(root, node, n));
                node = node.right;
            }
        }
        
        return result;
    }
    
    public TreeNode copyTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        return newRoot;
    }
    
    public TreeNode addNode(TreeNode root, TreeNode node, int n) {
        TreeNode newRoot = copyTree(root);
        TreeNode newNode = newRoot;
        
        while (root != node) {
            root = root.right;
            newNode = newNode.right;
        }
        
        TreeNode nodeToAdd = new TreeNode(n);
        nodeToAdd.left = newNode.right;
        newNode.right = nodeToAdd;
        
        return newRoot;
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
}