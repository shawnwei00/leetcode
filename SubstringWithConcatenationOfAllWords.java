import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words 
 * exactly once and without any intervening characters.
 * 
 * For example, given:
 * 
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 */

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (s == null || words == null || words.length == 0) return result;
        
        int n = words.length;
        int sl = s.length();
        int wl = words[0].length();
        
        if (n * wl > sl) return result;
        
        for (int i = 0; i <= sl - n * wl; i++) {
            if (helper(s, words, i)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    public Map<String, Integer> getMap(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (String string : words) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string)+1);
            } else {
                map.put(string, 1);
            }
        }
        
        return map;
    }
    
    public boolean helper(String s, String[] words, int start) {
        Map<String, Integer> map = getMap(words);
        int n = words[0].length();
        
        while (!map.isEmpty()) {
            String word = s.substring(start, start + n);
            if (map.containsKey(word)) {
                int count = map.get(word);
                if (count > 1) {
                    map.put(word, count - 1);
                } else {
                    map.remove(word);
                }
                start += n;
            } else {
                return false;
            }
        }
        
        return true;
    }
}


