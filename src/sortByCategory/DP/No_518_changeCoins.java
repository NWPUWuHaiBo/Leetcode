package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-06-01 9:19
 */
public class No_518_changeCoins {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int coins2[] = {2};
        System.out.println(change(3, coins));
    }

    private static int count = 0;

    public static int change(int amount, int[] coins) {

        if (coins.length == 0 || amount == 0) return 0;
        return getHelper(amount, coins, 0);

    }

    private static int getHelper(int amount, int[] coins, int index) {
        if (amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return count++;
        }
        for (int i = index; i < coins.length; i++) {
            amount -= coins[i];
            getHelper(amount, coins, index++);
            index--;
        }
        return count;
    }

    public static  int change2(int amount, int[] coins) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[ amount];
    }

}
