import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 *
 */

public class ValidParentheses {
	
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        
        Stack<Character> stack = new Stack<Character>();
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                } 
                stack.pop();
            } else {
                // error handler
            }
        }
        
        return stack.isEmpty();
    }
}