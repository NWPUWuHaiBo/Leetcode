package Algorithm;

/**
 * @author haiboWu
 * @create 2020-06-05 21:05
 */
public class No_07_BoatOfPeople {
    public static void main(String[] args) {
        int nums = getNums();
        System.out.println(nums);
    }

    public static int getNums() {
        int n = 10;
        while (true) {
            //依据退出条件进行暴力穷举
            if (n % 12 == 0 && (n + 2) % 10 == 0 && (n + 2) / 10 == n / 12 + 1) {
                break;
            }
            n++;
        }
        return n;
    }
}
