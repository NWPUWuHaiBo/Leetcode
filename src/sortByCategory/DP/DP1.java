package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-02-10 10:16
 */
public class DP1 {
    public static int[] result;

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println(rob2(nums));
    }

    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[nums.length - 1];
    }

    public static int rob(int[] nums) {
        result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        return getMax(nums.length - 1, nums);
    }

    public static int getMax(int n, int[] nums) {
        if (n < 0) return 0;
        if (result[n] > 0) {
            return result[n];
        }

        result[n] = Math.max(nums[n] + getMax(n - 2, nums), getMax(n - 1, nums));
        return result[n];
    }

}
