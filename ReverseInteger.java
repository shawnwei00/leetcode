/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Have you thought about this?
 * 
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 */

public class ReverseInteger {
    public int reverse(int x) {
        long reverse = reverseWithoutOverflow(x);
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;
        return (int) reverse;
    }
    
    public long reverseWithoutOverflow(long x) {
        if (x < 0) return -1 * reverseWithoutOverflow(-x);
        if (x == 0) return 0;
        if (x >= 1 && x <= 9) return x;
        
        long reverse = 0;
        while (x > 0) {
            long lastDigit = x % 10;
            reverse = reverse * 10 + lastDigit;
            x = x / 10;
        }
        
        return reverse;
    }
}