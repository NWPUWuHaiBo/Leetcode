package Algorithm;

/**
 * @author haiboWu
 * @create 2020-05-15 8:26
 */
public class No_04_GetSteps {
    public static void main(String[] args) {
        System.out.println(getSteps(6));
    }

    public static int getSteps(int n) {
        if (n < 0) return 0;
        if (n == 1 || n == 0) return 1;

        return getSteps(n - 1) + getSteps(n - 2) + getSteps(n - 3)
                + getSteps(n - 4) + getSteps(n - 5) + getSteps(n - 6);


    }
}
