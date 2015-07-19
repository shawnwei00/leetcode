/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        process(root);
        
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    public void process(TreeNode node) {
        if (node == null) return;
        
        process(node.left);
        
        if (firstElement == null && prevElement.val >= node.val) {
            firstElement = prevElement;
        }
        
        if (firstElement != null && prevElement.val >= node.val) {
            secondElement = node;
        }
        
        prevElement = node;
        
        process(node.right);
    }
    
    public static class TreeNode {
    	int val ;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
}