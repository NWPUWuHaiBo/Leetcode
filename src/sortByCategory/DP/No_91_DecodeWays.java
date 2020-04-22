package sortByCategory.DP;

/**
 * @author haiboWu
 * @create 2020-04-05 19:17
 */
public class No_91_DecodeWays {

    public int numDecodingsByDigui(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length() + 1; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if(one!=0){
                dp[i]+=dp[i-1];
            }
            if(s.charAt(i-2)=='0'){
                continue;
            }
            int two=Integer.valueOf(s.substring(i-2,i));
            if(two<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }

    private int digui(String s, int index) {
        return 0;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int dp[] = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
