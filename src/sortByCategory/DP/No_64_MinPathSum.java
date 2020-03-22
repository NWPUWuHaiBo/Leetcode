package sortByCategory.DP;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-22 10:47
 */
public class No_64_MinPathSum {
    @Test
    public void Test() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0 && i != 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else if (j != 0 && i != 0) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}
