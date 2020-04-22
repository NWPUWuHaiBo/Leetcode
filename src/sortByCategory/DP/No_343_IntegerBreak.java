package sortByCategory.DP;

import org.junit.Test;

/**
 * @author haiboWu
 * @create 2020-03-23 20:06
 */
public class No_343_IntegerBreak {
    @Test
    public void test() {
        System.out.println(dp(10));
    }

    //递归方式
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            //如果当前的n-i 比integerBreak(n-i)还要大，就不需要继续分解了
            res = Math.max(res, Math.max(i * integerBreak(n - i), i * (n - i)));
        }
        return res;
    }

    //备忘录的方式来实现，仍然是自顶向下
    public int integerBreak2(int n) {

        int[] bw = new int[n + 1];
        return helper(bw,n);
    }

    private int helper(int[] bw, int n) {
        if (n == 2) {
            return 1;
        }
        if(bw[n]!=0){
            return bw[n];
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            //如果当前的n-i 比integerBreak(n-i)还要大，就不需要继续分解了
            res = Math.max(res, Math.max(i * helper(bw,n - i), i * (n - i)));
        }
        //记录
        bw[n]=res;
        return res;
    }
    public int dp(int n){
        if(n==2)return 1;
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j <i-1 ; j++) {
                dp[i]=Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }
        return dp[n];
    }
}
