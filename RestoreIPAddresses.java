import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * 
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        List<Integer> list = new ArrayList<Integer>();
        
        if (s == null || s.length() < 4) return result;
        
        process(s, list, result, 0);
        
        return result;
    }
    
    public void process(String s, List<Integer> list, List<String> result, int n) {
        if (n == 4 && s.length() == 0) result.add(toString(list));
        if (n == 4 && s.length() > 0) return;
        
        if (s.length() >= 1) {
            int num1 = Integer.parseInt(s.substring(0, 1));
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(num1);
            process(s.substring(1), newList, result, n+1);
        }
        
        if (s.length() >= 2) {
            int num2 = Integer.parseInt(s.substring(0, 2));
            if (num2 >= 10 && num2 <= 99) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num2);
                process(s.substring(2), newList, result, n+1);
            }
        }
        
        if (s.length() >= 3) {
            int num3 = Integer.parseInt(s.substring(0, 3));
            if (num3 >= 100 && num3 <= 255) {
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num3);
                process(s.substring(3), newList, result, n+1);
            }
        }
    }
    
    public String toString(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for (Integer i : list) {
            sb.append(i);
            sb.append(".");
        }
        String str = sb.toString();
        return str.substring(0, str.length()-1);
    }
}