import java.util.HashMap;
import java.util.Map;


/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
        public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        
        Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        int result = 0;
        
        for (int left = 0, right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            if (charIndexMap.containsKey(c)) {
                left = Math.max(left, charIndexMap.get(c)+1);
            }
            
            charIndexMap.put(c, right);
            result = Math.max(result, right-left+1);
        }
        
        return result;
    }

}