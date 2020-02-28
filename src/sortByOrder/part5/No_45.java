package sortByOrder.part5;

/**
 * @author haiboWu
 * @create 2020-02-19 19:11
 */
public class No_45 {
    public static void main(String[] args) {
        int []nums={1};
        System.out.println(new No_45().jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int index = 0;
        int step = 0;
        int curMax = 0;
        int nextMax = 0;

        while (index <= curMax) {
            while (index <= curMax) {
                nextMax = Math.max(nextMax, index + nums[index]);
                index++;
            }
            curMax = nextMax;
            step++;
            if (nextMax >= nums.length - 1) return step;
        }
        return 0;
    }

}
