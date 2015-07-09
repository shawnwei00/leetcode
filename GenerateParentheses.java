import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 */

public class GenerateParentheses {
	
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    public void backtrack(List<String> list, String s, int open, int close, int max) {
        if (s.length() == 2 * max) {
            list.add(s);
            return;
        }
        
        if (open < max) {
            backtrack(list, s + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, s + ")", open, close + 1, max);
        }
    }
}