package sortByCategory.DivideAndConquer;

import java.util.Arrays;

/**
 * @author haiboWu
 * @create 2020-03-09 16:27
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSortDemo mergeSortDemo = new MergeSortDemo();
        mergeSortDemo.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        divided(arr, 0, arr.length - 1, temp);
    }

    private void divided(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            divided(arr, left, mid, temp);
            divided(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            temp[t++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
