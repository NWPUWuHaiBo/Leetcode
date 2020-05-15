package Algorithm;

/**
 * @author haiboWu
 * @create 2020-05-15 8:00
 */
public class No_02_LuckyNumber {
    public static void main(String[] args) {
        int res = getLucyNumber(21);
        System.out.println(res);
    }

    private static int getLucyNumber(int n) {
        int res = 0;
        while (n-- > 0) {
            if (getFx(n) == getGx(n)) {
                res++;
            }
        }
        return res;
    }


    private static int getGx(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) - '0';
        }
        return res;
    }

    private static int getFx(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n = n / 10;
        }
        return res;
    }
}
