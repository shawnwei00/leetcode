/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 */
public class ReverseNodesInKGroup {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        head = dummyHead;
        ListNode tail = head.next;
        
        while (tail != null) {
            for (int i = 1; i < k; i++) {
                tail = tail.next;
                if (tail == null) return dummyHead.next;
            }
            
            tail = tail.next;
            
            ListNode node = head.next;
            while (node.next != tail) {
                ListNode next = node.next;
                node.next = next.next;
                next.next = head.next;
                head.next = next;
            }
            
            head = node;
        }
        
        return dummyHead.next;
        
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}