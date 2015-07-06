
/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored
 * in reverse order and each of their nodes contain a single digit. Add the two numbers and return 
 * it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 *
 */

public class AddTwoNumbers {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        return addTwoNumbers(l1, l2, 0);
    }
    
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(carry);
            }
        }
        
        if (l1 == null) return addTwoNumbers(l2, carry);
        if (l2 == null) return addTwoNumbers(l1, carry);
        
        int sum = l1.val + l2.val + carry;
        ListNode result = new ListNode(sum % 10);
        result.next = addTwoNumbers(l1.next, l2.next, sum / 10);
        return result;
    }
    
    private ListNode addTwoNumbers(ListNode l, int carry) {
        if (l == null) {
            if (carry == 0) {
                return null;
            } else {
                return new ListNode(carry);
            }
        }
        
        int sum = l.val + carry;
        ListNode result = new ListNode(sum % 10);
        result.next = addTwoNumbers(l.next, sum / 10);
        return result;
    }
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}