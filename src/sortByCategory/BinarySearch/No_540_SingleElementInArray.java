package sortByCategory.BinarySearch;

/**
 * @author haiboWu
 * @create 2020-03-07 15:46
 */
public class No_540_SingleElementInArray {
    /**
     * 一个有序数组只有一个数不出现两次，找出这个数
     * 要求在O(log n)的时间复杂度
     *
     * 这次我们根据 数组长度的奇偶性 来缩减区间长度
     *
     * 如果[left,mid]长度为偶数，则目标在 [mid+1,right]中，反之亦然
     * 这次我们用的不是 left<= right,因为我们想要数组最后剩下的就是目标
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        //因为我要找的区间是最后一个，所以去掉等号
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isEven = (right - mid) % 2 == 0;
            //确保 mid 一定是两个重复的数，第一次出现的位置
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
            //确保 mid 一定是两个重复的数，第一次出现的位置
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
