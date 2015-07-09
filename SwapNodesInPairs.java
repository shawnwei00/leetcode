/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values 
 * in the list, only nodes itself can be changed.
 * 
 */

public class SwapNodesInPairs {
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode node1 = dummyHead;
        ListNode node2 = head;
        ListNode node3 = head.next;
        
        while (node2 != null && node3 != null) {
            node1.next = node3;
            node2.next = node3.next;
            node3.next = node2;
            
            node1 = node2;
            node2 = node1.next == null ? null : node1.next;
            node3 = (node2 == null || node2.next == null) ? null : node2.next;
        }
        
        return dummyHead.next;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}