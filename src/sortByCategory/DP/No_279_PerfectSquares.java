package sortByCategory.DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-04-03 23:07
 */
public class No_279_PerfectSquares {
    @Test
    public void test() {
        System.out.println(dp(13));
    }

    /**
     * 递归的方法步骤：
     * 1.将搜索的过程按照树状图画出来
     * 2.找到递推公式
     * 3.确定边界return的条件
     *
     * @param n
     * @return
     */
    public int digui(int n) {
        if (n == 0) return 0;
        int res = Integer.MAX_VALUE;
        List<Integer> squares = getAllSquares(n);
        System.out.println(squares.toString());
        for (int i = 0; i < squares.size(); i++) {
            res = Math.min(res, 1 + digui(n - squares.get(i)));
        }
        return res;
    }

    public int memory(int n) {
        int[] bw = new int[n + 1];
        return helper(bw, n);
    }

    private int helper(int[] bw, int n) {
        if (n == 0) return 0;
        if (bw[n] != 0) return bw[n];
        int res = Integer.MAX_VALUE;
        List<Integer> allSquares = getAllSquares(n);
        for (int i = 0; i < allSquares.size(); i++) {
            res = Math.min(res, 1 + helper(bw, n - allSquares.get(i)));
        }
        bw[n] = res;
        return res;
    }

    public int dp(int n) {
        int[] dp = new int[n + 1];
        List<Integer> allSquares = getAllSquares(n);
        for (int i = 1; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < allSquares.size(); j++) {
                if (allSquares.get(j) > i) {
                    break;
                } else {
                    min = Math.min(min, 1 + dp[i - allSquares.get(j)]);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }


    private List<Integer> getAllSquares(int n) {
        int k = 1;
        List<Integer> squares = new ArrayList();
        while (k * k <= n) {
            squares.add(k * k);
            k++;
        }
        return squares;
    }
}
