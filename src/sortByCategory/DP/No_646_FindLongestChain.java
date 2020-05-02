package sortByCategory.DP;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-04-22 10:38
 */
public class No_646_FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length==0)return 0;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int dp[]=new int[pairs.length];
        dp[0]=1;
        int res=1;
        for (int i = 1; i <pairs.length ; i++) {
            int maxTmp=1;
            for (int j = 0; j <i ; j++) {
                int b=pairs[j][1];
                int c=pairs[i][0];
                if(b<c){
                    maxTmp=Math.max(maxTmp,dp[j]+1);
                }
            }
            dp[i]=maxTmp;
            res=Math.max(dp[i],res);
        }
        return res;
    }
}
