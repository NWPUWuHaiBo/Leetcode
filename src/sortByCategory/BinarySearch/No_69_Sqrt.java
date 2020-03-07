package sortByCategory.BinarySearch;

/**
 * @author haiboWu
 * @create 2020-03-07 10:02
 */
public class No_69_Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (sqrt > mid) {
                left = mid+1;
            } else if (sqrt < mid) {
                right = mid-1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
