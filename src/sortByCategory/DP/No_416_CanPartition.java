package sortByCategory.DP;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-05-28 17:06
 */
public class No_416_CanPartition {
    public static void main(String[] args) {
        int nums[] = {1, 5, 11, 5};
        getCanpartition(nums);
    }

    private static boolean getCanpartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int w = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][w + 1];
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length][w];
    }
}
