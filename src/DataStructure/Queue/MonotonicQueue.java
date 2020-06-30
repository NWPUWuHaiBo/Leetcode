package DataStructure.Queue;

import java.util.*;

/**
 * @author haiboWu
 * @create 2020-06-24 19:22
 */
public class MonotonicQueue {

    int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
            return o2 - o1;
        }));
        int n = nums.length;
        int res[] = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (queue.size() == k) {
                //这里不是删除最小的，而应该是删除第i-k个元素
                queue.remove(nums[i - k]);
            }
            queue.offer(nums[i]);
            if (i >= k - 1) {
                res[index++] = queue.peek();
            }
        }
        return res;
    }

    int[] maxSlidingWindow2(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(((o1, o2) -> {
            return o2 - o1;
        }));
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int result[] = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                Integer v = treeMap.get(nums[i - k]);
                if (v == 1) {
                    treeMap.remove(nums[i - k]);
                } else {
                    treeMap.put(nums[i - k], v - 1);
                }
            }
            Integer v = treeMap.get(nums[i]);
            if (v == null) {
                treeMap.put(nums[i], 1);
            } else {
                treeMap.put(nums[i], v + 1);
            }
            if (i >= k - 1) {

                result[index++] = treeMap.firstKey();
            }
        }
        return result;
    }

    public int[] maxSlidingWindows(int[] nums, int k) {
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        if (n == 0) return nums;
        int result[] = new int[n - k + 1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (max.peekFirst() == nums[i - k]) {
                    max.removeFirst();
                }
            }
            while (!max.isEmpty() && nums[i] > max.peekLast()) {
                max.removeLast();
            }

            max.addLast(nums[i]);
            if (i >= k - 1) {
                result[index++] = max.peekFirst();
            }
        }
        return result;
    }
}
