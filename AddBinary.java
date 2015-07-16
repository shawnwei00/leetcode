/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * 
 * a = "11"
 * b = "1"
 * 
 * Return "100".
 *
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) return null;
        
        int length = Math.max(a.length(), b.length());
        int[] A = convert(a, length);
        int[] B = convert(b, length);
        int[] C = new int[length+1];
        
        int carrier = 0;
        for (int i = length-1; i>= 0; i--) {
            int sum = carrier + A[i] + B[i];
            C[i+1] = sum % 2;
            carrier = sum / 2;
        }
        
        StringBuffer sb = new StringBuffer();
        if (carrier == 1) sb.append("1");
        
        for (int i = 1; i <= length; i++) {
            sb.append((char) ('0' + C[i]));
        }
        
        return sb.toString();
    }
    
    public int[] convert(String str, int length) {
        int[] result = new int[length];
        int offset = length - str.length();
        
        for (int i = 0; i < str.length(); i++) {
            result[offset+i] = str.charAt(i) - '0';
        }
        
        return result;
    }
}