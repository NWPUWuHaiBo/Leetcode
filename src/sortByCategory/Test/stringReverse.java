package sortByCategory.Test;

import javax.sound.midi.SoundbankResource;

/**
 * @author haiboWu
 * @create 2020-06-10 15:11
 */
public class stringReverse {
    public static void main(String[] args) {
        String s = "the blue is sky";
        char[] str = s.toCharArray();
        int left = str.length - 1, right = str.length - 1;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[left] != ' ') {
                left--;
            } else if (str[left] == ' ') {
                myReverse(str, left + 1, right);
                left = i - 1;
                right = i - 1;
            } else if (i == 0) {
                myReverse(str, left, right);
            }
        }
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i]);
        }
    }

    private static void myReverse(char[] str, int left, int right) {
        int mid = (right - left) / 2 + left;
        for (int i = left; i <= mid; i++) {
            char t = str[i];
            str[i] = str[right];
            str[right] = t;
            right--;
        }
    }
}
