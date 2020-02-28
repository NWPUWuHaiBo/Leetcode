package sortByOrder.part6;

/**
 * @author haiboWu
 * @create 2020-02-19 19:17
 */
public class No_55 {
    public static void main(String[] args) {
        int nums[] = {3,2,1,0,4};
        System.out.println(new No_55().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int maxReach = 0;
        for (int i = 0; i < nums.length&&i<=maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return false;
    }
}
