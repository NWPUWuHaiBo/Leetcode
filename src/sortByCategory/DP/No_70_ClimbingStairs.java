package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-03-20 23:13
 */
public class No_70_ClimbingStairs {
    //1.自顶向下，备忘录法
    public int climbStairs(int n) {

        int[] note = new int[n + 1];
        int result = getnums(note, n);
        return result;
    }

    public int getnums(int[] note, int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (note[n] != 0) {
            return note[n];
        }
        note[n] = getnums(note, n - 1) + getnums(note, n - 2);
        return note[n];
    }

    //动态规划方法，自底向上
    public int climbStairs2(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] note = new int[n + 1];
        note[1] = 1;
        note[2] = 2;
        for (int i = 3; i <= n; i++) {
            note[i] = note[i - 1] + note[i - 2];
        }

        return note[n];
    }
}
