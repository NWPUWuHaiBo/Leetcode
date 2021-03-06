package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-06-03 16:07
 */
public class No_123_MaxProfitsWithOnlyTwice {
    public static void main(String[] args) {
        int prices[] = {3, 3, 5, 0, 0, 3, 1, 4};
        int res = maxProfit2(prices);
        System.out.println(res);
    }

    private static int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][3][2];
        for (int i = 0; i < 3; i++) {
            dp[0][i][1] = Integer.MIN_VALUE;
            dp[0][i][0] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=Integer.MIN_VALUE;
                }else{
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i-1]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i-1]);
                }
            }
        }
        return dp[n][2][0];
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i - 1]);
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
            }
        }
        return dp[n][1][0];
    }


}
