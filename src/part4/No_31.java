package part4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author haiboWu
 * @create 2020-02-13 19:19
 */

public class No_31 {

    public static void main(String[] args) {
//        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        int[] nums = {1, 3, 2};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));

    }

    public static void nextPermutation(int[] nums) {
        int max = nums[nums.length - 1];
        int i = 0, j = 0;
        boolean flag = false;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max)
                max = nums[i];
            else if (nums[i] < max) {
                flag = true;
                break;
            }
        }
        if (flag) {
            for (j = nums.length - 1; j > 0; j--) {
                if (nums[j] > nums[i]) break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            Arrays.sort(nums, i + 1, nums.length);
            return;
        }
        Arrays.sort(nums);
    }
}
