import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * Note:
 * 
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 *
 */

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n < 0) return result;
        if (n == 0) {
            result.add(0);
            return result;
        }
        
        List<Integer> list = grayCode(n - 1);
        
        List<Integer> secondHalf = new ArrayList<Integer>(list);
        Collections.reverse(secondHalf);
        for (int i = 0; i < secondHalf.size(); i++) {
            secondHalf.set(i, secondHalf.get(i) + (int) Math.pow(2, n-1));
        }
        
        result.addAll(list);
        result.addAll(secondHalf);
        
        return result;
    }
}