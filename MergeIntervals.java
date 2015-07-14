import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 *
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
           @Override
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           }
        });
        
        List<Interval> result = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0) {
                result.add(new Interval(intervals.get(0).start, intervals.get(0).end));
            } else {
                Interval i1 = result.get(result.size() - 1);
                Interval i2 = intervals.get(i);
                
                if (i2.start > i1.end) {
                    result.add(new Interval(i2.start, i2.end));
                } else {
                    i1.end = Math.max(i1.end, i2.end);
                }
            }
        }
        
        return result;
    }
    
    public static class Interval {
    	int start;
    	int end;
    	Interval() { start = 0; end = 0; }
    	Interval(int s, int e) { start = s; end = e; }
    }
}