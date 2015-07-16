/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) return null;
        
        if (isMax(digits)) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        
        int carrier = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            int sum = digits[i] + carrier;
            digits[i] = sum % 10;
            carrier = sum / 10;
            if (carrier == 0) break;
        }
        
        return digits;
    }
    
    public boolean isMax(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) return false;
        }
        return true;
    }
}