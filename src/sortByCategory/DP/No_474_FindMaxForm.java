package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-05-31 8:55
 */
public class No_474_FindMaxForm {
    public static void main(String[] args) {

        int m = 5, n = 3;
        String strs[] = {"10", "0001", "111001", "1", "0"};
        int res = findMaxForm2(strs, m, n);
        System.out.println(res);
    }

    private static int findMaxForm2(String[] strs, int m, int n) {
        //m是0的个数，n是1的个数
        int dp[][][] = new int[strs.length + 1][m + 1][n + 1];
        for (int k = 1; k < strs.length + 1; k++) {
            int[] count = countZerosOnes(strs[k - 1]);
            for (int i = 0; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];
                    if (i >= count[0] && j >= count[1])
                        dp[k][i][j] = Math.max(dp[k - 1][i][j], 1 + dp[k - 1][i - count[0]][j - count[1]]);
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private static int findMaxForm(String[] strs, int m, int n) {
        //m是0的个数，n是1的个数
        int dp[][] = new int[m + 1][n + 1];
        for (int k = 0; k < strs.length; k++) {
            int[] count = countZerosOnes(strs[k]);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - count[0]][j - count[1]]);
                }
            }
        }
        return dp[m][n];
    }

    private static int[] countZerosOnes(String str) {
        int[] c = new int[2];
        for (int i = 0; i < str.length(); i++) {
            c[str.charAt(i) - '0']++;
        }
        return c;
    }

}
