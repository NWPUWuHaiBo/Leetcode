package Algorithm;

/**
 * @author haiboWu
 * @create 2020-05-15 8:13
 */
public class No_03_GetMinTran {
    /**
     * 对输入的数组进行第一个数和最后一个数同时扫描，如果相等，跳过两个数的处理，
     * 第一位向后移动一位，最后一位向前移动一位。若不相等，
     * 第一种情况：第一位小于最后一位，则将第一位与它后一位相加为一个数，记录一次操作，进入递归。
     * 第二种情况：第一位大于最后一位：将最后一位与它前一位相加为一个数，记录一次操作，进入递归。
     */
    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 1, 3};
        System.out.println(getMinTran(arr));
    }

    private static int getMinTran(int[] arr) {
        int l = 0, r = arr.length - 1;
        return helper(arr, l, r);

    }

    private static int helper(int[] arr, int l, int r) {
        while (l < r) {
            if (arr[l] == arr[r]) {
                l++;
                r--;
            } else if (arr[l] < arr[r]) {
                arr[l + 1] = arr[l] + arr[l + 1];
                return 1 + helper(arr, l + 1, r);
            } else {
                arr[r - 1] = arr[r] + arr[r - 1];
                return 1 + helper(arr, l, r - 1);
            }
        }
        return 0;
    }

}
