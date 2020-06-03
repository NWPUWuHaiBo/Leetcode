package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-06-03 15:38
 */
public class No_309_MaxProfitsWithCoolDown {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(arr));

    }

    private static int maxProfit(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n + 1][2];
        //0代表没有股票，1代表持有股票
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i-1]);
            if (i - 2 < 0) {
                dp[i][1] = -arr[i-1];
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - arr[i-1]);
            }
        }
        return dp[n][0];
    }
}
