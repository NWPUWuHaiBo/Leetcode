package sortByCategory.DP;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-21 16:16
 */
public class No_198_HouseRobber {
    @Test
    public void Test() {
        int nums[] = {1, 2, 3, 1};
        System.out.println(rob2(nums));
    }

    public int rob2(int nums[]) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1=cur;
        }
        return pre1;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int res[] = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[nums.length - 1];
    }
}
