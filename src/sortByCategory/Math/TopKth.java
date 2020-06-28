package sortByCategory.Math;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author haiboWu
 * @create 2020-06-17 17:11
 */
public class TopKth {
    @Test
    public void testKth() {
        int nums[] = {3, 1, 6, 2, 8, 4, 9, 0};
        int Kth = findKthLagest(nums, 3);
        System.out.println(Kth);
    }

    public int findKthLagest(int[] nums, int k) {
        //默认创建的是最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
