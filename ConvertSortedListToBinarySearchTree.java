/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode node = new TreeNode(slow.next.val);
        ListNode secondHead = slow.next.next;
        slow.next = null;
        
        node.left = sortedListToBST(dummyHead.next);
        node.right = sortedListToBST(secondHead);
        
        return node;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}