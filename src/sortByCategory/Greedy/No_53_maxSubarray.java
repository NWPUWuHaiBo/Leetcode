package sortByCategory.Greedy;

/**
 * @author haiboWu
 * @create 2020-03-05 17:13
 */
public class No_53_maxSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int presum = nums[0];
        int maxsum = presum;
        for (int i = 1; i < nums.length; i++) {
            presum = presum > 0 ? presum + nums[i] : nums[i];
            maxsum = Math.max(presum, maxsum);
        }
        return maxsum;
    }
}
