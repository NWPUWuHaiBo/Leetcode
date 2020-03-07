package sortByCategory.BinarySearch;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-05 18:36
 */
public class BinarySearch {
    @Test
    public void test() {
        int a[] = {1, 2, 3, 4, 5};
        System.out.println(binarySearch2(a, 4));
    }

    public int binarySearch(int a[], int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (target > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearch2(int a[], int target) {
        int left = 0;
        int right = a.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (target > a[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(a[left]==target)return left;
        else  if(a[right]==target)return right;
        return -1;
    }
}
