package sortByCategory.BinarySearch;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-30 21:41
 */
public class No_33_SearchinRotatedSortedArray {
    @Test
    public void myTest() {

//        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int nums[] = {2, 1};
        System.out.println(search2(nums, 1));
    }


    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                //这说明【left,mid】这是一个递增的区间
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right]) {
                //这说明【mid,right】是一个递增区间
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                if (nums[right] > nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                if (nums[left] <= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
