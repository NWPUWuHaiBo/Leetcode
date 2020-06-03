package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-06-03 15:58
 */
public class No_714_MaxProfitWithFee {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    private static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]-fee);
        }
        return dp[n][0];
    }
}
