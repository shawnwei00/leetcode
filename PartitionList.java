/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before 
 * nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * 
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode dummyHead1 = new ListNode(0);
        dummyHead1.next = head;
        
        ListNode dummyHead2 = new ListNode(0);
        
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        
        while (node1.next != null) {
            if (node1.next.val >= x) {
                node2.next = node1.next;
                node2 = node2.next;
                node1.next = node1.next.next;
                node2.next = null;
            } else {
                node1 = node1.next;
            }
        }
        
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}