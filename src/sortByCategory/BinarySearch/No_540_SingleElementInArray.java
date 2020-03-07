package sortByCategory.BinarySearch;

import java.applet.Applet;

/**
 * @author haiboWu
 * @create 2020-03-07 15:46
 */
public class No_540_SingleElementInArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        //因为我要找的区间是最后一个，所以去掉等号
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isEven = (right - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return left;
    }

    public int singleNonDuplicate2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else if (nums[mid] == nums[mid - 1]) {
                right = mid - 2;
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }
}
