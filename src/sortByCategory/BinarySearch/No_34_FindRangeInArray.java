package sortByCategory.BinarySearch;

/**
 * @author haiboWu
 * @create 2020-03-08 15:15
 */
public class No_34_FindRangeInArray {
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[]{-1, -1};
        if (nums == null || nums.length <= 0) return res;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left > nums.length || nums[left] != target) return res;
        else {
            res[0] = left;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }
}
