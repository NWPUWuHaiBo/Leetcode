package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-03-22 10:40
 */

/*
        NowCoder每天要给很多人发邮件。有一天他发现发错了邮件，把发给A的邮件发给了B，
        把发给B的邮件发给了A。于是他就思考，要给n个人发邮件，在每个人仅收到1封邮件的情况下，
        有多少种情况是所有人都收到了错误的邮件？
        即没有人收到属于自己的邮件。
*/
public class ErrorNum {
    public int getNum(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 0;
        }
        int dp[] = new int[num + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < num + 1; i++) {
            dp[i]=(i-1)*dp[i-1]+(i-1)*dp[i-2];
        }
        return dp[num];
    }
}
