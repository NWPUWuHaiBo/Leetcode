package sortByCategory.BinarySearch;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-05 18:36
 */
public class BinarySearch {
    @Test
    public void test() {
//        int a[] = {1, 2,2, 3, 4, 4, 5};
        int a[] = {1, 2, 2, 4};
        System.out.println(binarySearch(a, 3));
//        System.out.println(rightBound(a, 2));
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

    public int leftBound(int a[], int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                right = mid - 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else if (a[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= a.length || a[left] != target) {
            return -1;
        }
        return left;
    }

    public int rightBound(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                left = mid + 1;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else if (a[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || a[right] != target) {
            return -1;
        }
        return right;
    }
}
