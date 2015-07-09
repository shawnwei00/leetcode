import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
           @Override
           public int compare(ListNode node1, ListNode node2) {
               return node1.val - node2.val;
           }
        });
        
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) heap.offer(lists[i]);
        }
        
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) heap.offer(node.next);
        }
        
        return dummyHead.next;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
    
}