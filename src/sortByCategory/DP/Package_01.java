package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-05-28 20:59
 */
public class Package_01 {
    public static void main(String[] args) {
        int weight = 10;
        int w[] = {2, 3, 4, 7};
        int v[] = {1, 3, 5, 9};
        int max = getMaxValue(weight, w, v);
        System.out.println(max);
    }

    //滚动数组，时间复杂度不变，空间复杂度降低
    private static int getMaxValue2(int weight, int[] w, int[] v) {
        int dp[] = new int[weight + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = weight; j >= 0; j--) { //这里按照从大到小的顺序来
                if(w[i-1]<=j){
                    dp[j]=Math.max(dp[j],dp[j-w[i-1]]+v[i-1]);
                }
            }
        }
        return dp[weight];
    }

    private static int getMaxValue(int weight, int[] w, int[] v) {
        int dp[][] = new int[w.length + 1][weight + 1];
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < weight + 1; j++) {
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[w.length][weight];
    }

}
