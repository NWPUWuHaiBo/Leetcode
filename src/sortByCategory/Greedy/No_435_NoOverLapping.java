package sortByCategory.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author haiboWu
 * @create 2020-03-01 21:25
 */
public class No_435_NoOverLapping {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b)->{return a[1]-b[1];});
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int max = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < max) {
                continue;
            }
            max = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
