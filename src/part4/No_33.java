package part4;

/**
 * @author haiboWu
 * @create 2020-02-14 19:16
 */
public class No_33 {
    public static void main(String[] args) {
        int nums[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(binarySearch(nums, 81));
        int nums2[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums2, 0));
    }

    public static int binarySearch(int nums[], int target) {
        if (nums == null || nums.length <= 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;

    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}
