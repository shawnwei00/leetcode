/**
 * Implement pow(x, n).
 *  
 */

public class Pow {
    public double myPow(double x, int n) {
        return myPow(x, (long) n);
    }
    
    public double myPow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return 1.0 / myPow(x, -n);
        
        double d = myPow(x, n / 2);
        return n % 2 == 0 ? d * d : d * d * x;
    }
}