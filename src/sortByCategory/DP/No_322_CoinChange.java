package sortByCategory.DP;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-23 20:26
 */
public class No_322_CoinChange {
    @Test
    public void Test() {
        int coins[] = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    int res = Integer.MAX_VALUE;

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
        return beiwang(coins, amount,bw);
    }

    private int beiwang(int[] coins, int amount,int bw[]) {
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(bw[amount-1]!=0){
            return bw[amount-1];
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res=beiwang(coins,amount-coins[i],bw);
            if(res>=0&&res<min){
                min=res+1;
            }
        }
        bw[amount-1]=(min==Integer.MAX_VALUE?-1:min);
        return bw[amount-1];
    }
}
