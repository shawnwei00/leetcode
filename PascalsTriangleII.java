import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * 
 * Return [1,3,3,1].
 * 
 * Note:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 */

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (rowIndex < 0) return list;
        
        list.add(1);
        if (rowIndex == 0) {
            return list;
        }
        
        for (int row = 1; row <= rowIndex; row++) {
            for (int i = 0; i < list.size()-1; i++) {
                list.set(i, list.get(i) + list.get(i+1));
            }
            list.add(0, 1);
        }
        
        return list;
    }
}