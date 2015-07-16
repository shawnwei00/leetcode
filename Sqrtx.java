/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 *
 */

public class Sqrtx {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        
        long guess = 1;
        while (!(guess * guess <= x && (guess+1) * (guess+1) > x)) {
            guess = (guess + x / guess) / 2;
        }
        
        return (int)guess;
    }
}