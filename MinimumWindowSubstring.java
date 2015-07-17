import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the 
 * characters in T in complexity O(n).
 * 
 * For example,
 * 
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one 
 * unique minimum window in S.
 *
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> map = getMap(t);
        
        int left = 0;
        String result = s + t;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if (isValid(map)) {
                    if (result.length() > (i - left + 1)) {
                		result = s.substring(left, i+1);
                	}
                    
                    while (true) {
                        char leftC = s.charAt(left);
                        left++;
                        if (!map.containsKey(leftC)) {
                            result = result.length() > (i - left + 1) ? s.substring(left, i+1) : result;
                        } else {
                            map.put(leftC, map.get(leftC) + 1);
                            if (isValid(map)) {
                                result = result.length() > (i - left + 1) ? s.substring(left, i+1) : result;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        if (result.length() > s.length()) return "";
        
        return result;
    }
    
    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        
        return map;
    }
    
    public boolean isValid(Map<Character, Integer> map) {
        for (Integer i : map.values()) {
            if (i > 0) return false;
        }
        return true;
    }
}