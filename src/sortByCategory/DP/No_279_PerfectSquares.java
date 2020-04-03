package sortByCategory.DP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haiboWu
 * @create 2020-04-03 23:07
 */
public class No_279_PerfectSquares {
    @Test
    public void test(){
        System.out.println(numSquares(13));
    }
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        List<Integer> squares;
        for (int i = 1; i <= n; i++) {
            squares = getAllSquares(i);
//            System.out.println(squares.size());
            for (Integer square : squares) {
                dp[i] = Math.min(dp[i],dp[i-square]+1);
            }
        }
        return dp[n];
    }

    private List<Integer> getAllSquares(int n) {
        int k = 1;
        List<Integer> squares = new ArrayList();
        while (k * k <= n) {
            squares.add(k*k);
            k++;
        }
        return squares;
    }
}
