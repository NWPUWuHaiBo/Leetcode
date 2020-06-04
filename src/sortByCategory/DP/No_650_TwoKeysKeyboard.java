package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-06-04 20:41
 */
public class No_650_TwoKeysKeyboard {
    public static void main(String[] args) {
        int n = 3;
        int minSteps = getMinSteps(n);
        System.out.println(minSteps);
    }

    private static int getMinSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                //找到一组分解因子
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

}
