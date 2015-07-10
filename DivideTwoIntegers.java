/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 *
 */

public class DivideTwoIntegers {
    
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long p = Math.abs((long) dividend);
        long q = Math.abs((long) divisor);
        
        long base = 1;
        long result = 0;
        
        while (p >= q) {
            base = base << 1;
            q = q << 1;
        }
        
        while (base >= 1) {
            if (p >= q) {
                result += base;
                p -= q;
            }
            q = q >> 1;
            base = base >> 1;
        }
        
        if ((dividend >= 0 && divisor > 0) || (dividend <= 0 && divisor < 0)) {
            return (int)result;
        } else {
            return -(int)result;
        }
    }
    
}