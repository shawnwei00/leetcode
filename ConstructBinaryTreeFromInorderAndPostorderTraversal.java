/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * 
 * You may assume that duplicates do not exist in the tree.
 * 
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        int l1 = inorder.length - 1;
        int l2 = postorder.length - 1;
        return buildTree(inorder, 0, l1, postorder, 0, l2);
    }
    
    public TreeNode buildTree(int[] io, int s1, int e1, int[] po, int s2, int e2) {
        if (s1 > e1) return null;
        if (s1 == e1) return new TreeNode(io[s1]);
        
        TreeNode node = new TreeNode(po[e2]);
        
        for (int offset = 0; offset+s1 <= e1; offset++) {
            if (io[s1+offset] == node.val) {
                node.left = buildTree(io, s1, s1+offset-1, po, s2, s2+offset-1);
                node.right = buildTree(io, s1+offset+1, e1, po, s2+offset, e2-1);
                return node;
            }
        }
        
        return node;
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}