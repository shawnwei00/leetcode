/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * 
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 */

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = head;
        ListNode cur = head.next;
        
        while (cur != null) {
            if (prev.val == cur.val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        
        return head;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}