package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-05-28 15:52
 */
public class LongestOfLCS {
    public static void main(String[] args) {
        int []nums1={};
        int []nums2={};
        getLongestOfLCS(nums1,nums2);
    }

    private static int getLongestOfLCS(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int[][]dp=new int[n1+1][n2+1];
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}
