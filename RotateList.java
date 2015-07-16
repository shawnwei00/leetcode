/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        
        k = k % getSize(head);
        
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        
        if (fast == null) return head;
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        if (slow == dummyHead) return head;
        
        // do the rotation
        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        
        return dummyHead.next;
    }
    
    public int getSize(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}