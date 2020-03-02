package sortByCategory.Greedy;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-03-02 22:31
 */
public class No_452_MinNumberToBustBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0)return 0;
        Arrays.sort(points,(o1, o2)->{return o1[1]-o2[1];});
        int cnt=1;
        int end=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=end){
                continue;
            }
            cnt++;
            end=points[i][1];
        }
        return cnt;
    }
}
