package sortByCategory.Math;

/**
 * @author haiboWu
 * @create 2020-06-17 10:49
 */
public class gcd {



    //最大公约数
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //最小公倍数
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
