/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * 
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        
        for (int i = 0; i < n; i++) {
            if (fast.next == null) return null;
            fast = fast.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummyHead.next;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}