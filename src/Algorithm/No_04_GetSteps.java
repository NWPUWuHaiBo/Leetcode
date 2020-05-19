package Algorithm;

/**
 * @author haiboWu
 * @create 2020-05-15 8:26
 */
public class No_04_GetSteps {
    /**
     * 与斐波那契数列思路相同
     * 递归所有可能的6种数字
     * 若当前数字小于0 则返回0
     * 当前数字等于0，则返回1
     */
    public static void main(String[] args) {
        System.out.println(getSteps(6));
    }

    public static int getSteps(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        return getSteps(n - 1) + getSteps(n - 2) + getSteps(n - 3)
                + getSteps(n - 4) + getSteps(n - 5) + getSteps(n - 6);
    }
}
