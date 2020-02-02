package part2;

import java.util.HashMap;

/**
 * @author haiboWu
 * @create 2020-02-02 20:04
 */
public class No_13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s == null) return 0;
        int len = s.length();
        int ans = getValue(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int pre = getValue(s.charAt(i - 1));
            int cur = getValue(s.charAt(i));
            if (pre < cur) {
                ans = ans + cur - pre - pre;
            } else {
                ans += cur;
            }
        }
        return ans;
    }

    public static int getValue(char a) {
        switch (a) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
