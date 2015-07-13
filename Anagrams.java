import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 *
 */

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        String[] copyStrs = Arrays.copyOf(strs, strs.length);
        
        for (int i = 0; i < copyStrs.length; i++) {
            char[] chars = copyStrs[i].toCharArray();
            Arrays.sort(chars);
            copyStrs[i] = new String(chars);
        }
        
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for (int i = 0; i < copyStrs.length; i++) {
            String str = copyStrs[i];
            if (map.containsKey(str)) {
                map.get(str).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(str, list);
            }
        }
        
        List<String> result = new ArrayList<String>();
        for (List<Integer> list : map.values()) {
            if (list.size() > 1) {
                for (Integer i : list) {
                    result.add(strs[i]);
                }
            }
        }
        
        return result;
    }
}