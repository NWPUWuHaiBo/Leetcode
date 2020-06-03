package sortByCategory.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-06-01 14:56
 */
public class No_377_CombinationSum4 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));

    }

    public static int combinationSum4(int[] nums, int target) {

        if (nums.length == 0 || target <= 0) return 0;

        int dp[] = new int[target + 1];

        dp[0] = 1;
        for (int j = 1; j < target + 1; j++) {
            for (int i = 1; i < nums.length + 1; i++) {
                if (nums[i - 1] <= j) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }

        return dp[target];
    }
}
