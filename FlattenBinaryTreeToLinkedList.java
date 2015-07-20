/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * 
 * Given

         1
        / \
       2   5
      / \   \
     3   4   6
     
 * The flattened tree should look like:
 * 
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 *
 */

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode node = root.left;
            
            while (node.right != null) {
                node = node.right;
            }
            
            node.right = root.right;
            root.right = root.left;
            root.left = null;
            
            flatten(root.right);
        } else {
            flatten(root.right);
        }
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}