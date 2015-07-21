import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * 
 * Return
 * 
 * [
 * 	    [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (numRows < 0) return result;
        
        for (int row = 1; row <= numRows; row++) {
            if (row == 1) {
                result.add(Arrays.asList(1));
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                List<Integer> prevList = result.get(result.size()-1);
                for (int i = 0; i < prevList.size()-1; i++) {
                    list.add(prevList.get(i) + prevList.get(i+1));
                }
                list.add(1);
                result.add(list);
            }
        }
        
        return result;
    }
}