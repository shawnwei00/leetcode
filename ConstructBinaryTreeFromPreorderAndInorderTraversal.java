/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * 
 * You may assume that duplicates do not exist in the tree.
 * 
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        int l1 = preorder.length-1;
        int l2 = inorder.length-1;
        return buildTree(preorder, 0, l1, inorder, 0, l2);
    }
    
    public TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 == e1) return new TreeNode(preorder[s1]);
        if (s1 > e1) return null;
        
        TreeNode node = new TreeNode(preorder[s1]);
        
        for (int offset = 0; offset <= e2-s2; offset++) {
            if (inorder[offset+s2] == node.val) {
                node.left = buildTree(preorder, s1+1, s1+offset, inorder, s2, s2+offset-1);
                node.right = buildTree(preorder, s1+offset+1, e1, inorder, s2+offset+1, e2);
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