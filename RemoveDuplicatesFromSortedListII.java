/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * 
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 */

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode prev = dummyHead;
        ListNode cur = head;
        ListNode next = head.next;
        
        while (next != null) {
            if (cur.val == next.val) {
                next = next.next;
            } else if (cur.next != next) {
                prev.next = next;
                cur = next;
                next = next.next;
            } else {
                prev = prev.next;
                cur = cur.next;
                next = next.next;
            }
        }
        
        if (cur.next != null) {
            prev.next = null;
        }
        
        return dummyHead.next;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}