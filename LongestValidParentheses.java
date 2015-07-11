import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the 
 * longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", 
 * which has length = 4.
 *
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, stack.isEmpty()? i + 1 : i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        
        return max;
    }
}