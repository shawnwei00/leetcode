/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * 
 * For example,
 * 
 * Given the following binary tree,
 * 
         1
       /  \
      2    3
     / \    \
    4   5    7
    
 * After calling your function, the tree should look like:
 * 
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
    
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode tempChild = new TreeLinkNode(0);
        TreeLinkNode child = tempChild;
        while (root != null) {
            if (root.left != null) {
                child.next = root.left;
                child = child.next;
            }
            if (root.right != null) {
                child.next = root.right;
                child = child.next;
            }
            root = root.next;
        }
        
        connect(tempChild.next);
    }
    
    public class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
    	TreeLinkNode(int x) { val = x; }
    }
}