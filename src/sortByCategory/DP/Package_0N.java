package sortByCategory.DP;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-05-28 20:59
 */
public class Package_0N {
    public static void main(String[] args) {
        int weight = 10;
        int w[] = {2, 3, 4, 7};
        int v[] = {1, 3, 5, 9};
        int max = getMaxValue2(weight, w, v);
        System.out.println(max);
    }

    //滚动数组，时间复杂度不变，空间复杂度降低
    private static int getMaxValue(int weight, int[] w, int[] v) {
        int dp[] = new int[weight + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = weight; j >= 0; j--) { //这里按照从大到小的顺序来
                for (int k = 0; k <= j / w[i - 1]; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * w[i - 1]] + k * v[i - 1]);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[weight];
    }

    private static int getMaxValue2(int weight, int[] w, int[] v) {
        int dp[] = new int[weight + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = w[i-1]; j < weight + 1; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
            }
        }
        return dp[weight];
    }

}
