package sortByCategory.BinarySearch;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-05 18:36
 */
public class BinarySearch2 {
    @Test
    public void test() {
        int nums[] = {1, 2, 3, 3, 4, 5, 6, 7};
        int left = getLeft(nums, 3);

        System.out.println(binarySearch(nums, 3));
    }

    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        int left = getLeft(nums, target);
        if (left == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        } else {
            res[0] = left;
            int index = left;
            while (nums[index] == target) {
                index++;
            }
            res[1] = index - 1;
            return res;
        }

    }

    public int getLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                left = mid - 1;
            } else {
                right = mid + 1;
            }
        }
        if (left >= nums.length) {
            return -1;
        } else {
            return left;
        }
    }

    public int binarySearch(int nums[], int target) {
        int left = 0, right = nums.length - 1;
        //区间长度？  [left,nums.length) [left,nums.length-1]
        //[2,2] =1 [2,2) =0
        while (left <= right) {
            //1. 带等于  left+1=right
            //不带等于  left=right
//            int mid = left + (right - left) / 2;
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int leftBound(int nums[], int target) {
        return -1;
    }

    public int rightBound(int[] nums, int target) {
        return -1;
    }
}
