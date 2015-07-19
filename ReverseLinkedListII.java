/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * 
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 *
 */

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        
        ListNode cur = head.next;
        ListNode next = cur.next;
        
        for (int i = m; i < n; i++) {
            cur.next = next.next;
            next.next = head.next;
            head.next = next;
            next = cur.next;
        }
        
        return dummyHead.next;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}