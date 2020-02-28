package sortByOrder.part2;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-02-03 17:13
 */
public class No_16 {
    public static void main(String[] args) {
        int nums[] = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));

    }

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        int ans = sum;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(ans-target)>Math.abs(sum-target)){
                    ans=sum;
                }
                if (sum == target) return target;
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}