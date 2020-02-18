package part4;

import java.util.ArrayList;

/**
 * @author haiboWu
 * @create 2020-02-14 21:13
 */
public class No_34 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length <= 0) return res;
        int left = 0, right = nums.length - 1;
        int mid = 0, start = -1, end = -1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) start = left;
        else if (nums[right] == target) start = right;
        if (start == -1) return res;

        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] == target) end = right;
        else if (nums[left] == target) end = left;

        res[0] = start;
        res[1] = end;
        return res;
    }
}
