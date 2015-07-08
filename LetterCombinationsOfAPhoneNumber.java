import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * {
 *   2: "abc";
 *   3: "def";
 *   4: "ghi";
 *   5: "jkl";
 *   6: "mno";
 *   7: "pqrs";
 *   8: "tuv";
 *   9: "wxyz";
 * }
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */

public class LetterCombinationsOfAPhoneNumber {
    
    public List<String> letterCombinations(String digits) {
        
        Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        
        return letterCombinations(digits, map);
    }
    
    
    private List<String> letterCombinations(String digits, Map<Integer, List<Character>> map) {
        List<String> result = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) return result;
        
        List<String> list = letterCombinations(digits.substring(1), map);
        
        if (list.isEmpty()) {
            list.add("");
        }
        
        int firstDigit = digits.charAt(0) - '0';
        
        for (String s : list) {
            for (char c : map.get(firstDigit)) {
                result.add(c + s);
            }
        }
        
        return result;
    }
}


