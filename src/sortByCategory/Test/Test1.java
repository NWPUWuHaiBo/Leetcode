package sortByCategory.Test;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author haiboWu
 * @create 2020-03-29 16:21
 */
public class Test1 {
    @Test
    public void testStack() {
        System.out.println('A' - 'a');
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pollFirst());
//        System.out.println(stack.pollLast());
        stack.addFirst(5);
        for (Integer integer : stack) {
            System.out.print(integer);
        }
    }

    public static int result = 1;

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = getIndex(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    private static int getIndex(int[] arr, int left, int right) {
        int temp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = temp;
        return left;
    }

    @Test
    public void testIsCharac() {
        System.out.println(3%4);
        String s = "0P";
        System.out.println(isPalindrome(s));

    }

    public boolean isPalindrome(String s) {
        StringBuilder sgood = new StringBuilder();
        int l = 0, h = s.length() - 1;
        for (; l < h; l++) {
            if (isCharac(s.charAt(l))) {
                sgood.append(Character.toLowerCase(s.charAt(l)));
            }
        }
        System.out.println(sgood.toString());
        l = 0;
        h = sgood.length() - 1;
        while (l < h) {
            if (sgood.charAt(l) != sgood.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }

    private boolean isCharac(char a) {
        if ((a - 'a' >= 0 && a - 'z' <= 0) || (a - 'A' >= 0 && a - 'Z' <= 0)) {
            return true;
        }
        return false;
    }

}
