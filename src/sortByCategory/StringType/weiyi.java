package sortByCategory.StringType;

import com.sun.deploy.util.StringUtils;

/**
 * @author haiboWu
 * @create 2020-11-30 20:14
 */
public class weiyi {
    public static void main(String[] args) {
        String s = "abcd123";
        int k = 3;
        String result = soulution(s, k);
        System.out.println(result);

        String s1 = "i am a student";
        System.out.println(soulution2(s1));
    }

    private static String soulution2(String s) {
        String temp = "";
        int i = 0;
        int pre = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                temp = temp + " " + reverse(s.substring(pre, i));
                pre = i + 1;
            }
            if (i == s.length() - 1) {
                temp = temp + " " + reverse(s.substring(pre, i + 1));
            }
            i++;
        }
        return reverse(temp);

    }

    private static String soulution(String s, int k) {
        String part1 = reverse(s.substring(0, s.length() - k));
        String part2 = reverse(s.substring(s.length() - k, s.length()));
        return reverse(part1 + part2);
    }

    private static String reverse(String s) {
        char sArr[] = s.toCharArray();
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            char temp = sArr[left];
            sArr[left] = sArr[right];
            sArr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(sArr);
    }

}
