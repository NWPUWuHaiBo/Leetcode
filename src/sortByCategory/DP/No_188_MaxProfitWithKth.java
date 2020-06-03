package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-06-03 16:31
 */
public class No_188_MaxProfitWithKth {
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        int res = maxProfit(prices, k);
        System.out.println(res);
    }

    private static int maxProfit(int[] prices, int k) {
        int n = prices.length;
        if(k==0||n<=0){
            return 0;
        }
        if (k >= n / 2) {
            return greedy(prices, n);
        }
        int dp[][][] = new int[n][k][2];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < k; j++) {
                if(i==0){
                    dp[i][j][1]=-prices[0];
                    dp[i][j][0]=0;
                }else{
                    if (j == 0) {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], -prices[i]);
                    } else {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i ]);
                    }
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                }

            }

        }
        return dp[n-1][k-1][0];
    }
    private static int greedy(int[] prices, int len) {
        // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
