package sortByCategory.QuickSort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author haiboWu
 * @create 2020-11-08 19:59
 */
public class QuickSearch {
    public static void main(String[] args) {
        int nums[] = new int[]{3, 2, 1, 5, 6, 4};
        int k = 5;
        int res = quickSearch(nums, k);
        System.out.println(res);
    }

    private static int quickSearch(int[] nums, int k) {
        int res = doQuickSearch(nums, 0, nums.length - 1, k);
        return res;
    }

    private static int doQuickSearch(int[] nums, int left, int right, int k) {
        int index = getIndex(nums, left, right);
        if (index == nums.length - k) {
            return nums[index];
        } else if (index > nums.length - k) {
            return doQuickSearch(nums, left, index - 1, k);
        } else {
            return doQuickSearch(nums, index + 1, right, k);
        }
    }

    private static int getIndex(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && temp <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && temp >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    private static int heapSort(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();

    }
}
