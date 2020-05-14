package sortByCategory.DP;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-04-05 19:58
 */
public class No_300_LongestIncreasingSubsequence {
    @Test
    public void test(){
//        int nums[]={10,9,2,5,3,7,101,18};
        int nums[]={1,2};
        System.out.println(lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int dp[] = new int[len + 1];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            maxAns=Math.max(max,dp[i]);
        }
        return maxAns;
    }

    public int lengthOfLIS2(int nums[]){
        if(nums.length==1)return 1;
        int res=1;
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,1);
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            res=Math.max(res,dp[i]);

        }
        return res;
    }
}
