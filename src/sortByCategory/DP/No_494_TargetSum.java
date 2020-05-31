package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-05-30 19:36
 */
public class No_494_TargetSum {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1};
        int S = 3;
        int ways = getTargetSum(nums, S);
        System.out.println(ways);
    }

    private static int getTargetSum(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = ComputeSum(nums);
        if (Math.abs(S) > sum) return 0;
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        if (nums[0] == 0) dp[0][sum] = 2;
        else {
            dp[0][sum - nums[0]] = 1;
            dp[0][sum + nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                int left = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int right = (j + nums[i]) < (sum * 2 + 1) ? j + nums[i] : 0;
                dp[i][j] = dp[i - 1][left] + dp[i - 1][right];
            }
        }
        return dp[nums.length - 1][sum + S];
    }

    private static int ComputeSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
