package sortByCategory.DP;

import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-03-23 20:26
 */
public class No_322_CoinChange {
    @Test
    public void Test() {
        int coins[] = {1, 2, 5};
        int coins2[] = {2};
        System.out.println(coinChange3(coins, 11));
    }

    int res = Integer.MAX_VALUE;


    public int coinChange3(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0) return -1;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i < amount + 1; i++) {

                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        digui(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void digui(int[] coins, int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            digui(coins, amount - coins[i], count + 1);
        }
    }

    @Test
    public void Test2() {
        int coins[] = {1, 2, 5};
        System.out.println(coinChange2(coins, 11));
    }

    private int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int bw[] = new int[amount];
        return beiwang(coins, amount, bw);
    }

    private int beiwang(int[] coins, int amount, int bw[]) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (bw[amount - 1] != 0) {
            return bw[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = beiwang(coins, amount - coins[i], bw);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        bw[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return bw[amount - 1];
    }
}
