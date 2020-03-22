package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-03-22 11:51
 */
public class No_62_UniquePath {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j!=0){
                    dp[i][j]=dp[i][j-1];
                }else if(j==0&&i!=0){
                    dp[i][j]=dp[i-1][j];
                }else if(j!=0&&i!=0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else {
                    dp[i][j]=1;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
