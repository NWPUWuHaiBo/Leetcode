package sortByCategory.DP;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-04-21 11:40
 */
public class No_300_lengthOfLIS {
    @Test
    public void Test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101};
        System.out.println(lengthOfLIS2(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int dp[] = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //贪心+二分查找
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length + 1];
        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //找到数组中刚好比他大的数组的后一位
            int left = 0, right = len-1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] == nums[i]) {
                    right = mid - 1;
                } else if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else if (dp[mid] > nums[i]) {
                    right = mid - 1;
                }
            }
            if (left >= len) {
                dp[len++] = nums[i];
            } else {
                dp[left] = nums[i];
            }
        }
        return len;
    }

}
